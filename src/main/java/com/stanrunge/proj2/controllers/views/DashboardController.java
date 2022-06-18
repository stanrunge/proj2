package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.JavaFXApplication;
import com.stanrunge.proj2.controllers.data.UserController;
import com.stanrunge.proj2.data.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class DashboardController {

    UserController userController;
    User currentUser;

    @FXML
    Label loggedInAsLabel;

    @FXML
    Label currentPointsLabel;

    @FXML
    TextField kilometersField;

    @FXML
    public void initialize() {
        userController = JavaFXApplication.getUserController();
        currentUser = JavaFXApplication.getLoggedInUser();
        loggedInAsLabel.setText("Logged in as " + currentUser.getUsername());
        currentPointsLabel.setText("Current points: " + currentUser.getPoints());
    }

    @FXML
    private void submitKilometers() {
        int kilometers = Integer.parseInt(kilometersField.getText());
        currentUser.setPoints(currentUser.getPoints() + kilometers);
        userController.updateUser(currentUser);
        currentPointsLabel.setText("Current points: " + currentUser.getPoints());
    }

}
