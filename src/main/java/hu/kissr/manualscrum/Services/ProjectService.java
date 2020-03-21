package hu.kissr.manualscrum.Services;

import hu.kissr.manualscrum.Models.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project findById(Integer id);

    Project create(Project project);

    Project update(Project project);

    void delete(Integer id);
}
