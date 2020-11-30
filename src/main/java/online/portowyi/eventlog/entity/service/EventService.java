package online.portowyi.eventlog.entity.service;

import online.portowyi.eventlog.entity.Event;
import online.portowyi.eventlog.entity.Transaction;
import online.portowyi.eventlog.entity.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        for (Event event : events){
            String ev_description = event.getEvent();

            if (ev_description.equals(TRANSACTION_BEGIN) || ev_description.equals(TRANSACTION_COMMIT)) {

                String transactionId = event.getTransactionID();
                Transaction transaction = transactionService.findById(transactionId);

                transaction.setTransactionID(transactionId);
                if (ev_description.equals(TRANSACTION_BEGIN)) transaction.setTransactionOpenDate(event.getDate());
                if (ev_description.equals(TRANSACTION_COMMIT)) {
                    transaction.setTransactionCommit(true);
                    transaction.setTransactionCommitDate(event.getDate());
                }

                transactionService.save(transaction);
            }
        }
    }
}
