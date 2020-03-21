package hu.kissr.manualscrum.Controllers;

import hu.kissr.manualscrum.Models.Project;
import hu.kissr.manualscrum.Services.ProjectServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    public final ProjectServiceImpl projServ;

    public ProjectController(ProjectServiceImpl projServ) {
        this.projServ = projServ;
    }

    @GetMapping(value = "/projects")
    public List<Project> findall() {
        return projServ.findAll();
    }

    @GetMapping(value = "/projects/{id}")
    public Project findById(@PathVariable("id") Integer id) {
        return projServ.findById(id);
    }

    @PostMapping(value = "/projects")
    public Project create(Project project) {
        return projServ.create(project);
    }

    @PutMapping(value = "/projects")
    public Project update(Project project) {
        return projServ.update(project);
    }

    @DeleteMapping(value = "/projects/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        projServ.delete(id);
    }
}
