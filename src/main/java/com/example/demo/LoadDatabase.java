package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    // Helper class to load dummy data into the database

    private static final Logger dbLogger = LoggerFactory.getLogger(LoadDatabase.class); // logger for database startup

    @Bean
    CommandLineRunner initDatabase (EmployeeRepository repository) {
        
        // Tutorial notes:
        // Spring boot runs CommandLineRunner beans once app is loaded
        // function takes new repository as an arg, and then adds these employees to repo
        
        return args -> {
            dbLogger.info("Preload " + repository.save(new Employee("Test User", "role 1")));
            dbLogger.info("Preload " + repository.save(new Employee("Test User 2", "role 2")));
        };
    }
}