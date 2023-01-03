package task.exercise.todoapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false)
    private long id;
    @NotBlank(message = "Task's description must not be null or empty")
    private String description;
    private boolean done;



    public Task(Long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public Task() {
    }



}
