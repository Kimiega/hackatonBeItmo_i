package space.arlet.meowhack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import space.arlet.meowhack.data.Task;
import space.arlet.meowhack.services.tasks.TasksService;

import java.util.List;

@RestController
@RequestMapping(value="${api_path}/tasks")
public class TasksController {

    private final TasksService tasksService;

    @Autowired
    TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Task> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @RequestMapping(value = "/completed", method = RequestMethod.GET)
    public List<Task> getAllCompletedTasks(long userId) {
        return tasksService.getAllCompletedTasks(userId);
    }

    @RequestMapping(value = "/uncompleted", method = RequestMethod.GET)
    public List<Task> getAllUncompletedTasks(long userId) {
        return tasksService.getAllUncompletedTasks(userId);
    }
}
