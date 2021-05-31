package com.epam.intro.subtask1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleApplication {
    @Autowired
    private FileSystemService fileSystemService;
    public static void main(String[] args) {

        SpringApplication.run(SimpleApplication.class, args);

    }
}
