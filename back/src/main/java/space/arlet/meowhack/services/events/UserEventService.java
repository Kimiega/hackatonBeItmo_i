package space.arlet.meowhack.services.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.data.UserEventInfo;
import space.arlet.meowhack.repositories.UserEventRepo;

import java.util.List;
import java.util.Objects;

@Service
public class UserEventService {
    private final UserEventRepo userEventRepo;
    private final EventService eventService;

    @Autowired
    public UserEventService(UserEventRepo userEventRepo, EventService eventService) {
        this.userEventRepo = userEventRepo;
        this.eventService = eventService;
    }

    public void addUserEvent(Long userId, EventInfo event) {
        UserEventInfo userEventInfo = new UserEventInfo();
        userEventInfo.setUserId(userId);
        userEventInfo.setEventId(event.getId());
        userEventRepo.save(userEventInfo);
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
