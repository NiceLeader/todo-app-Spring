package task.exercise.todoapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "task_groups")
@Getter
@Setter
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;
    @NotBlank(message = "Task group's description must not be null or empty")
    private String description;
    private boolean done;
//    @Embedded
//    private Audit audit = new Audit();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> tasks;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public TaskGroup(Long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public TaskGroup() {
    }



}
