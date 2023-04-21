package com.NGCPrompt.todo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(todoRepository repository) {
        return args -> {
            Todo chores = new Todo(1L, "Trash", "Smells horrible please take it out");
        Todo errands = new Todo(1L, "Mail", "Mail love letter to Cynthia");
    repository.saveAll(
        List.of(chores, errands)
    ); 
};

};
}
