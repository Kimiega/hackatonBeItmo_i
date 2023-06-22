package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.UserTask;

import java.util.List;

public interface UserTasksRepo extends JpaRepository<UserTask, Long> {
    List<UserTask> findAllByUserId(long userId);
}
