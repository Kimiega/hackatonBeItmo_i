package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.AchievementsCode;

public interface AchievementsCodesRepo extends JpaRepository<AchievementsCode, Long> {
    boolean existsByCode(String code);
    AchievementsCode getAchievCodeByCode(String code);
}
