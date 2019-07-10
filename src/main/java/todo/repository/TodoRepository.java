package todo.repository;

import todo.model.Todo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mekuanent Kassaye on 2019-06-21.
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
