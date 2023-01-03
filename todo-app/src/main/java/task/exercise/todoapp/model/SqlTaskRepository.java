package task.exercise.todoapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Long> {
    List<Task> findByDone(@Param("state") boolean done);
    @Override
    @Query(nativeQuery = true,value = "select count(*)>0 from tasks where id=:id")
    boolean existsById(@Param("id") Long id);

}