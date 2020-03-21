package hu.kissr.manualscrum.Services;

import hu.kissr.manualscrum.Models.Sprint;
import hu.kissr.manualscrum.Repository.SprintRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SprintServiceImpl implements SprintService{

    public final SprintRepository sprintRepo;
    public final ProjectService projServ;

    public SprintServiceImpl(SprintRepository sprintRepo, ProjectService projServ) {
        this.sprintRepo = sprintRepo;
        this.projServ = projServ;
    }

    @Override
    public List<Sprint> findAll() {
        return sprintRepo.findAll();
    }

    @Override
    public List<Sprint> findAllByProjId(Integer id) {

        projServ.findById(id);

        List<Sprint> allSprints = sprintRepo.findAll();
        List<Sprint> sprintsInProj = new java.util.ArrayList<>(Collections.emptyList());

        for (Sprint sprint: allSprints) {
            if (sprint.getProjectId().equals(id)) {
                sprintsInProj.add(sprint);
            }
        }
        return sprintsInProj;
    }

    @Override
    public Sprint findById(Integer id) {
        Optional<Sprint> optSprint = sprintRepo.findById(id);

        if (optSprint.isPresent()){
            return optSprint.get();
        } else {
            throw new NoResultException("Nincs ilyen Sprint");
        }
    }

    @Override
    public Sprint create(Sprint sprint) {
        projServ.findById(sprint.getProjectId());
        return sprintRepo.save(sprint);

    }

    @Override
    public void delete(Integer id) {
        sprintRepo.deleteById(id);

    }

    @Override
    public void deleteAllByProjId(Integer id) {
        projServ.findById(id);

        for (Sprint sprint: sprintRepo.findAll()) {
            if (sprint.getProjectId() == id) {
                sprintRepo.deleteById(sprint.getId());
            }

        }
    }

    @Override
    public Sprint update(Sprint sprint) {
        projServ.findById(sprint.getProjectId());
        return sprintRepo.save(sprint);
    }

}
