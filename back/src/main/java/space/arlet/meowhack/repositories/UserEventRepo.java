package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.UserEventInfo;

import java.util.List;

public interface UserEventRepo extends JpaRepository<UserEventInfo, Long> {
    List<UserEventInfo> findAllByUserId(long userId);
}
