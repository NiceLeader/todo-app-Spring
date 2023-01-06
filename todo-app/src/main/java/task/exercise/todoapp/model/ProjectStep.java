package task.exercise.todoapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "project_steps")
@Getter
@Setter
public class ProjectStep {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Project's description must not empty")
    private String description;

    private int daysToDeadline;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


}
