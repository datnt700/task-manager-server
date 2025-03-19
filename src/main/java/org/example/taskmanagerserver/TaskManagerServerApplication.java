package org.example.taskmanagerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class TaskManagerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerServerApplication.class, args);
    }

}
