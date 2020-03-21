package hu.kissr.manualscrum.Services;

import hu.kissr.manualscrum.Models.Sprint;

import java.util.List;

public interface SprintService {

    List<Sprint> findAll();

    List<Sprint> findAllByProjId(Integer id);

    Sprint findById(Integer id);

    Sprint create(Sprint sprint);

    void delete(Integer id);

    void deleteAllByProjId(Integer id);

    Sprint update(Sprint sprint);
}
