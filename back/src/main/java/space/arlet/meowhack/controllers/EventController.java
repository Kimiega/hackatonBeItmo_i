package space.arlet.meowhack.controllers;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.RandomUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.services.events.EventNotFoundException;
import space.arlet.meowhack.services.events.EventService;
import space.arlet.meowhack.services.events.UserEventService;

import java.util.List;

@RestController
@RequestMapping(value = "${api_path}/events")
public class EventController {
    private final EventService eventService;
    private final UserEventService userEventService;

    @Autowired
    EventController(EventService eventService, UserEventService userEventService) {
        this.eventService = eventService;
        this.userEventService = userEventService;
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
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ResponseEntity<Resource> registerUser(long userId, long eventId) {
        try {
            EventInfo eventInfo = userEventService.addUserEvent(userId, eventId);

            /* Generate unique identifier */
            UidGenerator ug = new RandomUidGenerator();
            Uid uid = ug.generateUid();

            VEvent event = new VEvent(new Date(java.util.Date.from(eventInfo.getStartTime().toInstant())), new Date(java.util.Date.from(eventInfo.getFinishTime().toInstant())), eventInfo.getName());
            event.getProperties().add(uid);

            /* Create calendar */
            Calendar calendar = new Calendar();
            calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
            calendar.getProperties().add(Version.VERSION_2_0);
            calendar.getProperties().add(CalScale.GREGORIAN);

            /* Add event to calendar */
            calendar.getComponents().add(event);

            byte[] calendarByte = calendar.toString().getBytes();
            Resource resource = new ByteArrayResource(calendarByte);

            HttpHeaders header = new HttpHeaders();
            header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=mycalendar.ics");
            header.add("Cache-Control", "no-cache, no-store, must-revalidate");
            header.add("Pragma", "no-cache");
            header.add("Expires", "0");

            return ResponseEntity.ok().headers(header).contentType(MediaType.
                            APPLICATION_OCTET_STREAM)
                    .body(resource);
            } catch (EventNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
