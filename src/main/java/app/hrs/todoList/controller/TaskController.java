package app.hrs.todoList.controller;

import app.hrs.todoList.model.Task;
import app.hrs.todoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public List<Task> index() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task show(@PathVariable String id) {
        int taskId = Integer.parseInt(id);
        Optional<Task> result = taskRepository.findById(taskId);
        if (result.isPresent() && result.get() != null)
            return result.get();
        else
            return null;
    }

    @PostMapping("/")
    public Task create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String description = body.get("description");
        return taskRepository.save(new Task(id, title, description));
    }

    @PostMapping("/{id}/check")
    public Task checkTask(@PathVariable String id) {
        int taskId = Integer.parseInt(id);

        Optional<Task> result = taskRepository.findById(taskId);
        if (result.isPresent() && result.get() != null) {
            Task t = result.get();
            t.setStatus(true);
            t.setUpdateDate(new GregorianCalendar());
            t.setFinishDate(t.getUpdateDate());
            return taskRepository.save(t);
        }
        else
            return null;
    }

    @PostMapping("/{id}/uncheck")
    public Task uncheckTask(@PathVariable String id) {
        int taskId = Integer.parseInt(id);

        Optional<Task> result = taskRepository.findById(taskId);
        if (result.isPresent() && result.get() != null) {
            Task t = result.get();
            t.setStatus(false);
            t.setUpdateDate(new GregorianCalendar());
            t.setFinishDate(null);
            return taskRepository.save(t);
        }
        else
            return null;
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int taskId = Integer.parseInt(id);
        String title = body.get("title");
        String description = body.get("description");

        Optional<Task> result = taskRepository.findById(taskId);
        if (result.isPresent() && result.get() != null) {
            Task t = result.get();
            t.setTitle(title);
            t.setDescription(description);
            t.setUpdateDate(new GregorianCalendar());
            return taskRepository.save(t);
        }
        else
            return null;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        int taskId = Integer.parseInt(id);
        taskRepository.deleteById(taskId);
        return true;
    }
}
