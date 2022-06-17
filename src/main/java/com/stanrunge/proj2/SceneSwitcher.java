package com.stanrunge.proj2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SceneSwitcher {
    ApplicationContext applicationContext;

    public SceneSwitcher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void switchScene(Stage stage, String resource) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        loader.setControllerFactory(applicationContext::getBean);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }
}