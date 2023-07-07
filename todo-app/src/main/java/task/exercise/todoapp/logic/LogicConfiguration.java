package task.exercise.todoapp.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import task.exercise.todoapp.TaskConfigurationProperties;
import task.exercise.todoapp.model.ProjectRepository;
import task.exercise.todoapp.model.TaskGroupRepository;

@Configuration
class LogicConfiguration {
    @Bean
    ProjectService service(
            final ProjectRepository repository,
            final TaskGroupRepository taskGroupRepository,
            final TaskConfigurationProperties config) {
        return new ProjectService(repository, taskGroupRepository, config);
    }

}
