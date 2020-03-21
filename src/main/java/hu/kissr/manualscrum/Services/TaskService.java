package hu.kissr.manualscrum.Services;

import hu.kissr.manualscrum.Models.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(Integer id);

    List<Task> findBySprintId(Integer id);

    Task create(Task task);

    Task update(Task task);

    void delete(Integer id);
}
