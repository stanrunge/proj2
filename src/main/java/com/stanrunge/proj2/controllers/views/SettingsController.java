package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.JavaFXApplication;
import com.stanrunge.proj2.SceneSwitcher;
import com.stanrunge.proj2.data.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SettingsController {

    User currentUser;
    SceneSwitcher sceneSwitcher;

    @FXML
    Button logOutButton;

    @FXML
    private void initialize() {
        currentUser = JavaFXApplication.getLoggedInUser();
        sceneSwitcher = JavaFXApplication.getSceneSwitcher();
    }

    @FXML
    private void logOut() throws IOException {
        currentUser = null;
        JavaFXApplication.setLoggedInUser(null);
        sceneSwitcher.switchScene((Stage) logOutButton.getScene().getWindow(), "/fxml/views/LoginView.fxml");
    }
}
