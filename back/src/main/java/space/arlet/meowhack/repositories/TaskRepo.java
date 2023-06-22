package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
