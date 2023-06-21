package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.UserAchievementInfo;

public interface UserAchievementsRepo extends JpaRepository<UserAchievementInfo, Long> {

}
