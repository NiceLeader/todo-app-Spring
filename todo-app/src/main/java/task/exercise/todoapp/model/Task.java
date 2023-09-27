package task.exercise.todoapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;
    @NotBlank(message = "Task's description must not be null or empty")
    private String description;
    private boolean done;
    private LocalDateTime deadline;

//    @Embedded
//    private Audit audit = new Audit();


    @ManyToOne
    @JoinColumn(name = "task_group_id")
    private TaskGroup group;

    public void updateFrom(final Task source) {
        description = source.description;
        done = source.done;
        deadline = source.deadline;
        group = source.group;
    }


    public Task(Long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;

    }

    public Task() {
    }

    public Task(String description, LocalDateTime deadline) {
        this.description = description;
        this.deadline = deadline;

    }


}
