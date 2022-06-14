package com.stanrunge.proj2;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Proj2Application {

    public static void main(String[] args) {
//        SpringApplication.run(Proj2Application.class, args);
        Application.launch(JavaFXApplication.class, args);
    }

}
