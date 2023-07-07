package task.exercise.todoapp.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task.exercise.todoapp.model.Project;
import task.exercise.todoapp.model.ProjectRepository;

import java.util.List;
public interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

    @Override
    @Query("from Project p join fetch p.steps")
    List<Project> findAll();


}
