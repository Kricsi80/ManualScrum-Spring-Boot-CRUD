package hu.kissr.manualscrum.Services;


import hu.kissr.manualscrum.Models.Employee;
import hu.kissr.manualscrum.Repository.EmployeeRepository;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // public final EmployeeRepository empRepo;

    @Autowired
    private EmployeeRepository empRepo;

    // public EmployeeServiceImpl(EmployeeRepository empRepo) {
    //     this.empRepo = empRepo;
    // }

    @Override
    public List<Employee> findAll() {
        return empRepo.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> optEmpl = empRepo.findById(id);

        if (optEmpl.isPresent()) {
            return optEmpl.get();
        } else {
            throw new NoResultException("Nincs ilyen Employee");
        }
    }

    @Override
    public Employee create(Employee employee) {
        empRepo.save(employee);
        return employee;
    }

    @Override
    public void delete(Integer id) {
        empRepo.deleteById(id);
    }

    @Override
    public Employee update(Employee employee) {
        empRepo.save(employee);
        return employee;
    }
}
