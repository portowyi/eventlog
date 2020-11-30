package online.portowyi.eventlog.entity.repository;

import online.portowyi.eventlog.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
