package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.AchievCode;

public interface AchievCodesRepo extends JpaRepository<AchievCode, Long> {
}
