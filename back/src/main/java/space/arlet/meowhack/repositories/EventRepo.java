package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.EventInfo;

public interface EventRepo extends JpaRepository<EventInfo, Long> {
}
