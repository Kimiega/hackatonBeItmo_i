package space.arlet.meowhack.services.events;

import net.fortuna.ical4j.model.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.data.UserEventInfo;
import space.arlet.meowhack.repositories.UserEventRepo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.RandomUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;

@Service
public class UserEventService {
    private final UserEventRepo userEventRepo;
    private final EventService eventService;

    @Autowired
    public UserEventService(UserEventRepo userEventRepo, EventService eventService) {
        this.userEventRepo = userEventRepo;
        this.eventService = eventService;
    }

    public EventInfo addUserEvent(Long userId, Long eventId) {
        UserEventInfo userEventInfo = new UserEventInfo();
        userEventInfo.setUserId(userId);
        userEventInfo.setEventId(eventId);
        userEventRepo.save(userEventInfo);
        return eventService.getEventById(eventId);
    }

    public List<UserEventInfo> getUserEventInfoByUserId(long userId) {
        return userEventRepo.findAll().stream().filter((info -> info.getUserId() == userId)).toList();
    }

    public UserEventInfo getUserEventInfoByUserIdAndEventId(long userId, long eventId) {
        return getUserEventInfoByUserId(userId).stream()
                .filter(it -> it.getEventId() == eventId).findAny().orElseThrow(EventNotFoundException::new);
    }

    public List<EventInfo> getUserEvents(long userId) {
        return getUserEventInfoByUserId(userId).stream().map(userEventInfo -> {
            try {
                return eventService.getEventById(userEventInfo.getEventId());
            } catch (EventNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }).filter(Objects::nonNull).toList();
    }


}
