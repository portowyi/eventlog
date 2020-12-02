package online.portowyi.eventlog.entity.repository;

import online.portowyi.eventlog.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    public List<Transaction> getTransactionsByTransactionDurationGreaterThan(Long transactionDuration);
}
