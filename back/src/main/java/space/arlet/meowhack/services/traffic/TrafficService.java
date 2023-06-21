package space.arlet.meowhack.services.traffic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.TrafficInfo;
import space.arlet.meowhack.repositories.TrafficRepo;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class TrafficService {
    private final TrafficRepo trafficRepo;

    @Autowired
    TrafficService(TrafficRepo trafficRepo) {
        this.trafficRepo = trafficRepo;
    }

    public void addTrafficInfo(TrafficInfo trafficInfo) {
        trafficRepo.save(trafficInfo);
    }

    public void addTrafficInfo(long userId,
                               ZonedDateTime enterTime,
                               ZonedDateTime exitTime,
                               String building,
                               String auditory) {
        TrafficInfo trafficInfo = new TrafficInfo();
        trafficInfo.setUserId(userId);
        trafficInfo.setEnterTime(enterTime);
        trafficInfo.setExitTime(exitTime);
        trafficInfo.setBuilding(building);
        trafficInfo.setAuditory(auditory);
        addTrafficInfo(trafficInfo);
    }

    public List<TrafficInfo> getTrafficInfosByUserId(long userId) {
        return trafficRepo.findAll().stream().filter(it -> it.getUserId() == userId).toList();
    }

    public TrafficInfo getLastTrafficInfoByUserId(long userId) {
        return trafficRepo.findAll().stream()
                .filter(it -> it.getUserId() == userId)
                .max(Comparator.comparing(TrafficInfo::getEnterTime)).orElse(null);
    }
}
