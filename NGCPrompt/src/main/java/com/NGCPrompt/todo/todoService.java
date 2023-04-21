package com.NGCPrompt.todo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class todoService {

	private final todoRepository todoRepository;
	
	@Autowired
	public todoService(todoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}


    public List<Todo> getTodoList() {
		return (List<Todo>) todoRepository.findAll();
	}

	public void addNewTodo(Todo todo) {
		Optional<Todo> todoByTitle = todoRepository.findTodoByTitle(todo.getTitle());
		if(todoByTitle.isPresent()) {
			throw new IllegalStateException("Todo item already in list");
		}
		todoRepository.save(todo);
	}

	public void deleteTodo(Long todoId) {
		boolean exists = todoRepository.existsById(todoId);
		if(!exists) {
			throw new IllegalStateException(
				"todo item with id " + todoId + " does not exist."
			);
		}
		todoRepository.deleteById(todoId);
	}
	@Transactional
	public void patchTodo(Long todoId, String title, String description) {
		Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new IllegalStateException("Todo item with id " + todoId + " does not exist"));
		
		if(title != null && title.length() > 0 && !Objects.equals(todo.getTitle(), title)) {
			todo.setTitle(title);
		}
		if(description != null && description.length() > 0 && !Objects.equals(todo.getDescription(), description)) {
			todo.setDescription(description);
		}
	}
}
