package task.exercise.todoapp.logic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import task.exercise.todoapp.model.TaskGroup;
import task.exercise.todoapp.model.TaskGroupRepository;
import task.exercise.todoapp.model.TaskRepository;
import task.exercise.todoapp.model.projection.GroupReadModel;
import task.exercise.todoapp.model.projection.GroupWriteModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope
public class TaskGroupService {
    private TaskGroupRepository repository;
    private TaskRepository taskRepository;
    public TaskGroupService(final TaskGroupRepository repository, final TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }
    public GroupReadModel createGroup(final GroupWriteModel source) {
        TaskGroup result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }
    public List<GroupReadModel> readAll() {
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());

    }
    public void toggleGroup(long groupId) {
        if (taskRepository.existsByDoneIsFalseAndGroup_Id(groupId)) {
            throw new IllegalStateException("Group has undone tasks. Done all the tasks first");
        }
        TaskGroup result = repository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("TaskGroup with given id not found"));
        result.setDone(!result.isDone());
        repository.save(result);
    }
}
