package online.portowyi.eventlog.entity.service;

import online.portowyi.eventlog.entity.Event;
import online.portowyi.eventlog.entity.Transaction;
import online.portowyi.eventlog.entity.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    private EventRepository eventRepository;
    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void saveAll(List<Event> events){
        eventRepository.saveAll(events);

        final String TRANSACTION_BEGIN = "_$Transaction$_.Begin";
        final String TRANSACTION_COMMIT = "_$Transaction$_.Commit";
        final String TRANSACTION_ROLLBACK = "_$Transaction$_.Rollback";

        Map<Integer, Transaction> transactionsMap = new HashMap<>();

        for (Event event : events){
            String ev_description = event.getEvent();
            if (ev_description.equals(TRANSACTION_BEGIN) || ev_description.equals(TRANSACTION_COMMIT) || ev_description.equals(TRANSACTION_ROLLBACK)) {

                String transactionId = event.getTransactionID();
                Transaction transaction = new Transaction();
                transaction.setTransactionID(transactionId);

                Integer hash = transaction.hashCode();

                Transaction tr = transactionsMap.get(hash);
                if (tr != null) transaction = tr;

                if (ev_description.equals(TRANSACTION_BEGIN)) transaction.setTransactionOpenDate(event.getDate());
                if (ev_description.equals(TRANSACTION_COMMIT)) {
                    transaction.setTransactionFinished(true);
                    transaction.setTransactionCommitDate(event.getDate());
                }
                if (ev_description.equals(TRANSACTION_ROLLBACK)) {
                    transaction.setTransactionFinished(true);
                    transaction.setTransactionRollbackDate(event.getDate());
                }
                transactionsMap.put(hash, transaction);
            }
        }
        List<Transaction> transactions = new ArrayList<Transaction>(transactionsMap.values());
        transactionService.saveAll(transactions);
    }
}
