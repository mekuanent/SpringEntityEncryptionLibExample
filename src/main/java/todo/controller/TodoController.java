package todo.controller;

import org.springframework.web.bind.annotation.*;
import todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import todo.repository.TodoRepository;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Mekuanent Kassaye on 2019-06-21.
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping(value = "/{title}/{desc}", method = RequestMethod.POST)
    public Todo insert(@PathVariable String title, @PathVariable String desc) {

        Todo todo = new Todo(title, desc);
        todoRepository.save(todo);

        return todo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Todo> list(){
        return todoRepository.findAll();
    }

    @RequestMapping(value = "/{id}/{title}/{desc}", method = RequestMethod.PATCH)
    public Todo update(@PathVariable Long id, @PathVariable String title, @PathVariable String desc){

        AtomicReference<Todo> todo = new AtomicReference<>();

        todoRepository.findById(id).ifPresent(t -> {
            t.setTitle(title);
            t.setDescription(desc);
            todo.set(todoRepository.save(t));
        });

        return todo.get();
    }

}
