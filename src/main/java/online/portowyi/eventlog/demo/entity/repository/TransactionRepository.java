package online.portowyi.eventlog.demo.entity.repository;

import online.portowyi.eventlog.demo.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
