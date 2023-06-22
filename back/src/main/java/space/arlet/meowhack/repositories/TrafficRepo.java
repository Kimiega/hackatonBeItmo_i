package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.TrafficInfo;

import java.util.List;

public interface TrafficRepo extends JpaRepository<TrafficInfo, Long> {
    List<TrafficInfo> findAllByUserId(long userId);
}
