package online.portowyi.eventlog.demo.controller;

import online.portowyi.eventlog.demo.entity.Event;
import online.portowyi.eventlog.demo.entity.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<?> loadEvents(@RequestBody List<Event> events){
        try {
            eventService.saveAll(events);
            return new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
