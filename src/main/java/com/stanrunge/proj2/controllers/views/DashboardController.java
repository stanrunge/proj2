package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.JavaFXApplication;
import com.stanrunge.proj2.data.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class DashboardController {

    User currentUser;

    @FXML
    Label loggedInAsLabel;

    @FXML
    Label currentPointsLabel;

    @FXML
    public void initialize() {
        currentUser = JavaFXApplication.getLoggedInUser();
        loggedInAsLabel.setText("Logged in as " + currentUser.getUsername());
        currentPointsLabel.setText("Current points: " + currentUser.getPoints());
    }

    @FXML
    private void submitKilometers() {

    }

}
