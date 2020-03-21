package hu.kissr.manualscrum.Services;

import hu.kissr.manualscrum.Models.Task;
import hu.kissr.manualscrum.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    public final TaskRepository taskRepo;
    public final SprintServiceImpl sprintServ;

    public TaskServiceImpl(TaskRepository taskRepo, SprintServiceImpl sprintServ) {
        this.taskRepo = taskRepo;
        this.sprintServ = sprintServ;
    }

    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public Task findById(Integer id) {
        Optional<Task> optTask = taskRepo.findById(id);

        if (optTask.isPresent()) {
            return optTask.get();
        } else {
            throw new NoResultException("Nincs ilyen Task");
        }
    }

    @Override
    public List<Task> findBySprintId(Integer id) {
        sprintServ.findById(id);

        List<Task> allTasks = taskRepo.findAll();
        List<Task> taskInSprint = new java.util.ArrayList<>(Collections.emptyList());

        for (Task task: allTasks) {
            if (task.getSprintId().equals(id)) {
                taskInSprint.add(task);
            }
        }

        return taskInSprint;
    }

    @Override
    public Task create(Task task) {
        sprintServ.findById(task.getSprintId());
        return taskRepo.save(task);
    }

    @Override
    public Task update(Task task) {
        sprintServ.findById(task.getSprintId());
        return taskRepo.save(task);
    }

    @Override
    public void delete(Integer id) {
        taskRepo.deleteById(id);
    }
}
