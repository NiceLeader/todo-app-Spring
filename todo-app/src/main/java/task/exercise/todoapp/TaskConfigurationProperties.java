package task.exercise.todoapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
public class TaskConfigurationProperties {
    private boolean allowMultipleTasks;

    public boolean isAllowMultipleTasks() {
        return allowMultipleTasks;
    }

    public void setAllowMultipleTasks(final boolean allowMultipleTasks) {
        this.allowMultipleTasks = allowMultipleTasks;
    }

}
