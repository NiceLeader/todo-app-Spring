package task.exercise.todoapp.model;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    List<Project> findAll();

    Optional<Project> findById(Long id);

    Project save(Project entity);

}
