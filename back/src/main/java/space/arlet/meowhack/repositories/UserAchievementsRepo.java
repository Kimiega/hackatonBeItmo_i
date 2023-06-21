package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.UserAchievementInfo;

import java.util.List;

public interface UserAchievementsRepo extends JpaRepository<UserAchievementInfo, Long> {
    List<UserAchievementInfo> getUserAchievementInfosByUserId(long userId);
}
