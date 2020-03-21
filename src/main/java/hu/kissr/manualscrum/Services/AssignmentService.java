package hu.kissr.manualscrum.Services;

import hu.kissr.manualscrum.Models.Assignment;

import java.util.List;

public interface AssignmentService {

    List<Assignment> findAll();

    Assignment findById(Integer id);

    Assignment create(Assignment assignment);

    void delete(Integer id);

    //ellenőrzések stb
    Assignment update(Assignment assignment);

    List<Assignment> findAllByEmpId(Integer id);

    List<Assignment> findAllByTaskId(Integer id);

    void deleteAllByEmpId(Integer id);

    void deleteAllByTaskId(Integer id);
}
