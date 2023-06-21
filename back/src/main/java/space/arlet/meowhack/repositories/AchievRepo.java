package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.Achiev;

public interface AchievRepo extends JpaRepository<Achiev, Long> {
    boolean existsByTitle(String title);
}
