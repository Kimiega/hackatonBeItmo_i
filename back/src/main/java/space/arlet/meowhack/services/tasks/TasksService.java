package space.arlet.meowhack.services.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.Task;
import space.arlet.meowhack.repositories.TaskRepo;
import space.arlet.meowhack.repositories.UserTasksRepo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TasksService {
    private final TaskRepo taskRepo;
    private final UserTasksRepo userTasksRepo;

    @Autowired
    TasksService(TaskRepo taskRepo, UserTasksRepo userTasksRepo) {
        this.taskRepo = taskRepo;
        this.userTasksRepo = userTasksRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public List<Task> getAllCompletedTasks(long userId) {
        return userTasksRepo.findAllByUserId(userId).stream()
                .map(element -> taskRepo.findById(element.getTaskId()).get())
                .collect(Collectors.toList());
    }

    public List<Task> getAllUncompletedTasks(long userId) {
        List<Task> tasks = getAllTasks();
        List<Task> completedTask = getAllCompletedTasks(userId);

        Set<Long> taskIdSet = completedTask.stream()
                .map(Task::getId)
                .collect(Collectors.toSet());

        return tasks.stream()
                .filter(element -> !taskIdSet.contains(element.getId()))
                .collect(Collectors.toList());
    }
}
