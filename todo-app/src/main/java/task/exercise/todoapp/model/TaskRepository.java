package task.exercise.todoapp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    List<Task> findAll();

    Page<Task> findAll(Pageable page);

    Optional<Task> findById(Long id);

    boolean existsById(Long id);

    boolean existsByDoneIsFalseAndGroup_Id(Long groupId);
    List<Task> findByDone(@Param("state") boolean done);

    Task save(Task entity);

}
