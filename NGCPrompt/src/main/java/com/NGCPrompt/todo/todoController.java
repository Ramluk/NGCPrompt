package com.NGCPrompt.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/ngc/todo")
public class todoController {

    private final todoService todoService;
    
    @Autowired
    public todoController(todoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping 
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }

    @PostMapping
    public void addNewTodo(@RequestBody Todo todo) {
        todoService.addNewTodo(todo);
    }
	@DeleteMapping(path = "{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
    }
    @PutMapping(path = "{todoId}")
    public void patchTodo(@PathVariable("todoId") Long todoId, @RequestParam(required = false) String title, @RequestParam(required = false) String description) {
        todoService.patchTodo(todoId, title, description);
    }

}
