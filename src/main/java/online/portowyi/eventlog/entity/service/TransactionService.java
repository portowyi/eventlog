package online.portowyi.eventlog.entity.service;

import online.portowyi.eventlog.entity.Transaction;
import online.portowyi.eventlog.entity.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Value("${longTransactionsDuration}")
    private Long longTransactionsDuration;

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

    public void saveAll(List<Transaction> transactions){
        transactionRepository.saveAll(transactions);
    }

    public List<Transaction> getLongTransactions(){
        return transactionRepository.getTransactionsByTransactionDurationGreaterThan(longTransactionsDuration);
    }

}
