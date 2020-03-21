package hu.kissr.manualscrum.Controllers;

import hu.kissr.manualscrum.Models.Assignment;
import hu.kissr.manualscrum.Services.AssignmentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {

    public final AssignmentServiceImpl assServ;

    public AssignmentController(AssignmentServiceImpl assServ) {
        this.assServ = assServ;
    }

    @GetMapping(value = "/assignments")
    public List<Assignment> findAll() {
        return assServ.findAll();
    }

    @GetMapping(value = "/assignments/{id}")
    public Assignment findById(@PathVariable("id") Integer id) {
        return assServ.findById(id);
    }

    @GetMapping(value = "/assignments/employee/{id}")
    public List<Assignment> findAllByEmpId(@PathVariable("id") Integer id) {
        return assServ.findAllByEmpId(id);
    }

    @GetMapping(value = "/assignments/task/{id}")
    public List<Assignment> findAllByTaskId(@PathVariable("id") Integer id) {
        return assServ.findAllByTaskId(id);
    }

    @PostMapping(value = "/assignments")
    public Assignment create(Assignment assignment) {
        return assServ.create(assignment);
    }

    @PutMapping(value = "/assignments")
    public Assignment update(Assignment assignment) {
        return assServ.update(assignment);
    }

    @DeleteMapping(value = "/assignments/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        assServ.delete(id);
    }

    @DeleteMapping(value = "/assignments/employee/{id}")
    public void deleteByEmpId(@PathVariable("id") Integer id) {
        assServ.deleteAllByEmpId(id);
    }

    @DeleteMapping(value = "/assignments/task/{id}")
    public void deleteByTaskId(@PathVariable("id") Integer id) {
        assServ.deleteAllByTaskId(id);
    }
}
