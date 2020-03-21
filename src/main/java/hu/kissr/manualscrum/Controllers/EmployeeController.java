package hu.kissr.manualscrum.Controllers;

import hu.kissr.manualscrum.Models.Employee;
import hu.kissr.manualscrum.Services.EmployeeServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    public final EmployeeServiceImpl empService;

    public EmployeeController(EmployeeServiceImpl empService) {
        this.empService = empService;
    }

    @GetMapping(value = "/employees")
    public List<Employee> findAll() {
        return empService.findAll();
    }

    @GetMapping(value = "employees/{id}")
    public Employee findById(@PathVariable("id") Integer id) {
        return empService.findById(id);
    }

    @PostMapping(value = "/employees")
    public Employee create(Employee employee) {
        return empService.create(employee);
    }

    @PutMapping(value = "/employees")
    public Employee update(Employee employee) {
        return empService.update(employee);
    }

    @DeleteMapping(value = "/employees/{id}")
    public void delet(@PathVariable("id") Integer id) {
        empService.delete(id);
    }
}
