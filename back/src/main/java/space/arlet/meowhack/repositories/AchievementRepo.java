package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.Achievement;

import java.util.List;

public interface AchievementRepo extends JpaRepository<Achievement, Long> {
    boolean existsByTitle(String title);
    List<Achievement> findAllByType(Achievement.Type type);
}
