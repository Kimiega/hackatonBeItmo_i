package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.UserAchievsInfo;

public interface UserAchievsRepo extends JpaRepository<UserAchievsInfo, Long> {
}
