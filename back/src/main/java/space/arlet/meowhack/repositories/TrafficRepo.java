package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.TrafficInfo;

public interface TrafficRepo extends JpaRepository<TrafficInfo, Long> {
}
