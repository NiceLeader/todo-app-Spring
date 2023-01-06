package task.exercise.todoapp.model.projection;

import lombok.Getter;
import lombok.Setter;
import task.exercise.todoapp.model.Task;

@Getter
@Setter
public class GroupTaskReadModel {
    private String description;
    private boolean done;

    public GroupTaskReadModel(Task source) {
        description = source.getDescription();
        done = source.isDone();

    }
}
