package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.JavaFXApplication;
import com.stanrunge.proj2.controllers.data.UserController;
import com.stanrunge.proj2.data.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

@Component
public class RewardsController {

    UserController userController;
    User currentUser;

    @FXML
    private void initialize() {
        userController = JavaFXApplication.getUserController();
        currentUser = JavaFXApplication.getLoggedInUser();
    }

    @FXML
    Button redeemButton;

    @FXML
    private void redeemReward() {
        currentUser.setPoints(currentUser.getPoints() - 1);
        userController.updateUser(currentUser);
    }
}
