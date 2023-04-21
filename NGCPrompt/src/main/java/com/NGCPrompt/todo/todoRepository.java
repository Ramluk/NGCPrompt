package com.NGCPrompt.todo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface todoRepository extends CrudRepository<Todo, Long> {
    
    Optional<Todo> findTodoByTitle(String title);
}
