package hu.kissr.manualscrum.Controllers;

import hu.kissr.manualscrum.Models.Task;
import hu.kissr.manualscrum.Services.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaksController {

    public final TaskServiceImpl taskServ;

    public TaksController(TaskServiceImpl taskServ) {
        this.taskServ = taskServ;
    }

    @GetMapping(value = "/tasks")
    public List<Task> findAll() {
        return taskServ.findAll();
    }

    @GetMapping(value = "/tasks/{id}")
    public Task findById(@PathVariable("id") Integer id) {
        return taskServ.findById(id);
    }

    @GetMapping(value = "/tasks/sprint/{id}")
    public List<Task> findBySprintId(@PathVariable("id") Integer id) {
        return taskServ.findBySprintId(id);
    }

    @PostMapping(value = "/tasks")
    public Task create(Task task) {
        return taskServ.create(task);
    }

    @PutMapping(value = "/tasks")
    public Task update(Task task) {
        return taskServ.update(task);
    }

    @DeleteMapping(value = "/task/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        taskServ.delete(id);
    }
}
