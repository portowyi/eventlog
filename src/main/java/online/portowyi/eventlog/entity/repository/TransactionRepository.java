package online.portowyi.eventlog.entity.repository;

import online.portowyi.eventlog.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
