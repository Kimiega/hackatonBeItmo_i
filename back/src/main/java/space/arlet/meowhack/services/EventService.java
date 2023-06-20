package space.arlet.meowhack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.repositories.EventRepo;

import java.util.Comparator;
import java.util.List;

@Service
public class EventService {
    private final EventRepo eventRepo;

    public EventService(@Autowired EventRepo eventRepo) {
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
}
