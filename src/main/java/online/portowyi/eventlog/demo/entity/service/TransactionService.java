package online.portowyi.eventlog.demo.entity.service;

import online.portowyi.eventlog.demo.entity.Transaction;
import online.portowyi.eventlog.demo.entity.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public void setActiveTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction findById (String transactionId){
        Optional<Transaction> res = transactionRepository.findById(transactionId);
        return res.orElseGet(Transaction::new);
    }

    public void save(Transaction transaction){
        transactionRepository.save(transaction);
    }

}
