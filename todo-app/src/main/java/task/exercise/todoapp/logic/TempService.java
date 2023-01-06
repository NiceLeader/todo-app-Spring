package task.exercise.todoapp.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.exercise.todoapp.model.Task;
import task.exercise.todoapp.model.TaskGroupRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TempService {
    @Autowired
    List<String> temp(TaskGroupRepository repository) {
        //FIXME: N+1 problem
        return repository.findAll().stream()
                .flatMap(taskGroup -> taskGroup.getTasks().stream())
                .map(Task::getDescription)
                .collect(Collectors.toList());

    }
}
