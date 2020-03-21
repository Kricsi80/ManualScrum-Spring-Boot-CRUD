package hu.kissr.manualscrum.Controllers;

import hu.kissr.manualscrum.Models.Sprint;
import hu.kissr.manualscrum.Services.SprintServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SprintController {
    public final SprintServiceImpl sprintServ;

    public SprintController(SprintServiceImpl sprintServ) {
        this.sprintServ = sprintServ;
    }

    @GetMapping(value = "/sprints")
    public List<Sprint> findAll() {
        return sprintServ.findAll();
    }

    @GetMapping(value = "/sprints/{id}")
    public Sprint findById(@PathVariable("id") Integer id) {
        return sprintServ.findById(id);
    }

    @GetMapping(value = "/sprints/project/{id}")
    public List<Sprint> findByProjId(@PathVariable("id") Integer id) {
        return sprintServ.findAllByProjId(id);
    }

    @PostMapping(value = "/sprints")
    public Sprint create(Sprint sprint) {
        return sprintServ.create(sprint);
    }

    @PutMapping(value = "/sprints")
    public Sprint update(Sprint sprint) {
        return sprintServ.update(sprint);
    }

    @DeleteMapping(value = "/sprints/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        sprintServ.delete(id);
    }

    @DeleteMapping(value = "/sprints/project{id}")
    public void deleteByProjId(@PathVariable("id") Integer id) {
        sprintServ.deleteAllByProjId(id);
    }
}
