package online.portowyi.eventlog.controller;

import online.portowyi.eventlog.entity.Event;
import online.portowyi.eventlog.entity.Transaction;
import online.portowyi.eventlog.entity.service.EventService;
import online.portowyi.eventlog.entity.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService;
    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

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

    @GetMapping ("/long")
    List<Transaction> getLongTransactions(){
        return transactionService.getLongTransactions();
    }

}
