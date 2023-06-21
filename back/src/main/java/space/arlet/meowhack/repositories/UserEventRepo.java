package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.UserEventInfo;

public interface UserEventRepo extends JpaRepository<UserEventInfo, Long> {
}
