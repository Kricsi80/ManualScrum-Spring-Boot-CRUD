package hu.kissr.manualscrum.Services;

import hu.kissr.manualscrum.Models.Assignment;
import hu.kissr.manualscrum.Repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService{

    public final AssignmentRepository assRepo;
    public final EmployeeServiceImpl emplServ;
    public final TaskServiceImpl taskserv;

    public AssignmentServiceImpl(AssignmentRepository assRepo, EmployeeServiceImpl emplServ, TaskServiceImpl taskserv) {
        this.assRepo = assRepo;
        this.emplServ = emplServ;
        this.taskserv = taskserv;
    }

    @Override
    public Assignment findById(Integer id) {
        Optional<Assignment> optAss = assRepo.findById(id);

        if (optAss.isPresent()) {
            return optAss.get();
        } else {
            throw new NoResultException("Nincs ilyen Assignment");
        }
    }

    @Override
    public List<Assignment> findAll() {
        return assRepo.findAll();
    }

    @Override
    public Assignment create(Assignment assignment) {
        emplServ.findById(assignment.getEmployeeId());
        taskserv.findById(assignment.getTaskId());

        assRepo.save(assignment);
        return assignment;
    }

    @Override
    public void delete(Integer id) {
        assRepo.deleteById(id);
    }

    @Override
    public Assignment update(Assignment assignment) {
        emplServ.findById(assignment.getEmployeeId());
        taskserv.findById(assignment.getTaskId());

        assRepo.save(assignment);
        return assignment;
    }

    @Override
    public List<Assignment> findAllByEmpId(Integer id) {
        emplServ.findById(id);
        List<Assignment> allAss = assRepo.findAll();
        List<Assignment> assByEmpId = new java.util.ArrayList<>(Collections.emptyList());

        for (Assignment ass: allAss) {
            if (ass.getEmployeeId().equals(id)) {
                assByEmpId.add(ass);
            }
        }

        return assByEmpId;
    }

    @Override
    public List<Assignment> findAllByTaskId(Integer id) {
        taskserv.findById(id);
        List<Assignment> allAss = assRepo.findAll();
        List<Assignment> assByTaskId = new java.util.ArrayList<>(Collections.emptyList());

        for (Assignment ass: allAss) {
            if (ass.getTaskId().equals(id)) {
                assByTaskId.add(ass);
            }
        }

        return assByTaskId;
    }

    @Override
    public void deleteAllByEmpId(Integer id) {
        emplServ.findById(id);
        List<Assignment> allAss = assRepo.findAll();

        for (Assignment ass: allAss) {
            if (ass.getEmployeeId().equals(id)) {
                assRepo.deleteById(ass.getId());
            }
        }

    }

    @Override
    public void deleteAllByTaskId(Integer id) {
        taskserv.findById(id);
        List<Assignment> allAss = assRepo.findAll();

        for (Assignment ass: allAss) {
            if (ass.getTaskId().equals(id)) {
                assRepo.deleteById(ass.getId());
            }
        }
    }
}
