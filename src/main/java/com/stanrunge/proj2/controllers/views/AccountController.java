package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.data.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.FileChooser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountController {

    User currentUser;

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        currentPointsLabel.setText("Current points: " + currentUser.getPoints());
        emailLabel.setText("Email: " + currentUser.getEmail());
        usernameLabel.setText("Username: " + currentUser.getUsername());
    }

    @FXML
    private Label errorChangePasswordLabel;

    @FXML
    private PasswordField changePasswordField;

    @FXML
    private Label currentPointsLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private PasswordField reEnterChangedPasswordField;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button changePasswordButton;

    @FXML
    private FileChooser fileChooser;

    @FXML
    private void changeProfilePicture() {

    }

    @FXML
    private void changePassword() {
        String hashedPassword = new BCryptPasswordEncoder().encode(changePasswordField.getText());
        currentUser.setHashedPassword(hashedPassword);
    }

    private boolean isSamePassword() {
        return changePasswordField.getText().equals(reEnterChangedPasswordField.getText());
    }

}
