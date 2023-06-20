package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.ProgressInfo;

public interface ProgressRepo extends JpaRepository<ProgressInfo, Long> {

}
