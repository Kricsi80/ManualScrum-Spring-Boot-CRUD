package hu.kissr.manualscrum.Services;

import hu.kissr.manualscrum.Models.Project;
import hu.kissr.manualscrum.Repository.ProjectRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
    public class ProjectServiceImpl implements ProjectService{

    public final ProjectRepository projRepo;

    public ProjectServiceImpl(ProjectRepository projRepo) {
        this.projRepo = projRepo;
    }

    @Override
    public List<Project> findAll() {
        return projRepo.findAll();
    }

    @Override
    public Project findById(Integer id) {
        Optional<Project> optProj = projRepo.findById(id);

        if (optProj.isPresent()) {
            return optProj.get();
        } else {
            throw new NoResultException("Nincs ilyen Project");
        }
    }

    @Override
    public Project create(Project project) {
        projRepo.save(project);
        return project;
    }

    @Override
    public Project update(Project project) {
        projRepo.save(project);
        return project;
    }

    @Override
    public void delete(Integer id) {
    projRepo.deleteById(id);
    }
}
