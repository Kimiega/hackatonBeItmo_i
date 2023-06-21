package space.arlet.meowhack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.services.events.EventNotFoundException;
import space.arlet.meowhack.services.events.EventService;

import java.util.List;

@RestController
@RequestMapping(value = "${api_path}/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addEvent(@RequestBody EventInfo eventInfo) {
        eventService.addEvent(eventInfo);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @RequestMapping(value = "/past", method = RequestMethod.GET)
    public ResponseEntity<List<EventInfo>> getPastEvents() {
        return new ResponseEntity<>(eventService.getPastEvents(), HttpStatus.OK);
    }
    @RequestMapping(value = "/actual", method = RequestMethod.GET)
    public ResponseEntity<List<EventInfo>> getActualEvents() {
        return new ResponseEntity<>(eventService.getActualEvents(), HttpStatus.OK);
    }
    @RequestMapping(value = "/future", method = RequestMethod.GET)
    public ResponseEntity<List<EventInfo>> getFutureEvents() {
        return new ResponseEntity<>(eventService.getFutureEvents(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<EventInfo> getEvent(long eventId) {
        try {
            return new ResponseEntity<>(eventService.getEventById(eventId), HttpStatus.OK);
        } catch (EventNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
