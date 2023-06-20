package space.arlet.meowhack.services.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.repositories.EventRepo;

import java.time.LocalTime;
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

    public List<EventInfo> getEvents() {
        return getEvents(5);
    }

    public List<EventInfo> getEvents(long countLast) {
        return eventRepo.findAll().stream().sorted(Comparator.comparing(EventInfo::getStartTime).reversed())
                .limit(countLast).toList();
    }

    public List<EventInfo> getActualEvents() {
        LocalTime now = LocalTime.now();
        return eventRepo.findAll().stream()
                .filter((event -> event.getStartTime().isBefore(now) && event.getFinishTime().isAfter(now)))
                .toList();
    }

    public List<EventInfo> getFutureEvents() {
        LocalTime now = LocalTime.now();
        return eventRepo.findAll().stream()
                .filter((event -> event.getStartTime().isAfter(now)))
                .toList();
    }

    public List<EventInfo> getPastEvents() {
        LocalTime now = LocalTime.now();
        return eventRepo.findAll().stream()
                .filter((event -> event.getFinishTime().isBefore(now)))
                .toList();
    }
}
