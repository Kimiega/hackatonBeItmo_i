package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.UserAchievementInfo;

public interface UserAchievsRepo extends JpaRepository<UserAchievementInfo, Long> {
}
