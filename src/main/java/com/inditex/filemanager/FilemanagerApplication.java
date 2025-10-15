package com.inditex.filemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FilemanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilemanagerApplication.class, args);
    }

}
