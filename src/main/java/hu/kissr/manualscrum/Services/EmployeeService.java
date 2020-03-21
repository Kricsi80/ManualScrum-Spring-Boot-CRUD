package hu.kissr.manualscrum.Services;


import hu.kissr.manualscrum.Models.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee create(Employee employee);

    void delete(Integer id);

    //ellenőrzések stb
    Employee update(Employee employee);
}
