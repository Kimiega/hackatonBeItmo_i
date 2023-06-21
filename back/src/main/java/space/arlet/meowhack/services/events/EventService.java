package space.arlet.meowhack.services.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.repositories.EventRepo;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class EventService {
    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public void addEvent(EventInfo event) {
        eventRepo.save(event);
    }

    public List<EventInfo> getAllEvents() {
        return getEvents(eventRepo.count());
    }

    public EventInfo getEventById(long eventId) {
        return eventRepo.findById(eventId).orElseThrow(EventNotFoundException::new);
    }

    public List<EventInfo> getEvents() {
        return getEvents(5);
    }

    public List<EventInfo> getEvents(long countLast) {
        return eventRepo.findAll().stream().sorted(sortByDate().reversed())
                .limit(countLast).toList();
    }

    public List<EventInfo> getActualEvents() {
        ZonedDateTime now = ZonedDateTime.now();
        return eventRepo.findAll().stream()
                .filter((event -> event.getStartTime().isBefore(now) && event.getFinishTime().isAfter(now)))
                .toList();
    }

    public List<EventInfo> getFutureEvents() {
        ZonedDateTime now = ZonedDateTime.now();
        return eventRepo.findAll().stream()
                .filter((event -> event.getStartTime().isAfter(now)))
                .toList();
    }

    public List<EventInfo> getPastEvents() {
        ZonedDateTime now = ZonedDateTime.now();
        return eventRepo.findAll().stream()
                .filter((event -> event.getFinishTime().isBefore(now)))
                .toList();
    }

    public Comparator<EventInfo> sortByDate() {
        return Comparator.comparing(EventInfo::getStartTime);
    }
}
