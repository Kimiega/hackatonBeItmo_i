package space.arlet.meowhack.services;

import lombok.Getter;
import lombok.Setter;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.data.ProgressInfo;
import space.arlet.meowhack.services.events.EventService;
import space.arlet.meowhack.services.progress.ProgressService;

import java.util.*;

@Service
public class RecommendationService {
    private final static long countEventsForFirstDirection = 3;
    private final EventService eventService;
    private final ProgressService progressService;

    @Autowired
    public RecommendationService(EventService eventService, ProgressService progressService) {
        this.eventService = eventService;
        this.progressService = progressService;
    }
    public List<EventInfo> getRecommendationList(long userId) {
        ProgressInfo progress = progressService.getProgressInfoByUserId(userId);
        List<EventInfo> actualAndFutureEvents = StreamEx.of(eventService.getActualEvents())
                .append(eventService.getFutureEvents()).toList();
        return magicAnalyse(progress, actualAndFutureEvents);
    }

    private List<EventInfo> magicAnalyse(ProgressInfo progress, List<EventInfo> events) {
        List<EventInfo> recommendedEvents = new ArrayList<>();
        Map<Direction, List<EventInfo>> priorities = new TreeMap<>(
                (o1, o2) -> Long.compare(progressService.getLevelByDirection(progress, o2),
                        progressService.getLevelByDirection(progress, o1)));

        for (var direction : Direction.values()) {
            priorities.put(direction,
                    events.stream().filter(event -> Direction.from(event.getDirection()) == direction)
                            .sorted(eventService.sortByDate().reversed()).toList());
        }
        long countOfEvents = countEventsForFirstDirection;
        for (var ev : priorities.values()) {
            ev.stream().limit(countOfEvents).forEach(recommendedEvents::add);
            countOfEvents--;
            countOfEvents = Math.max(countOfEvents, 1);
        }
        Collections.shuffle(recommendedEvents);
        return recommendedEvents;
    }
}
