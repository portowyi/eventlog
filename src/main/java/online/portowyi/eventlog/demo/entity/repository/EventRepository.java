package online.portowyi.eventlog.demo.entity.repository;

import online.portowyi.eventlog.demo.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
