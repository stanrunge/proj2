package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.JavaFXApplication;
import com.stanrunge.proj2.controllers.data.UserController;
import com.stanrunge.proj2.data.User;
import com.stanrunge.proj2.repositories.UserRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountController {

    User currentUser;
    UserController userController;

    @FXML
    private void initialize() {
        currentUser = JavaFXApplication.getLoggedInUser();
        userController = JavaFXApplication.getUserController();
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
    private ImageView profilePictureImageView;

    @FXML
    private void changeProfilePicture() {

    }

    @FXML
    private void changePassword() {
        if (!isSamePassword()) {
            errorChangePasswordLabel.setText("Passwords do not match");
            return;
        }

        String hashedPassword = new BCryptPasswordEncoder().encode(changePasswordField.getText());
        currentUser.setHashedPassword(hashedPassword);

        userController.updateUser(currentUser);
        errorChangePasswordLabel.setText("Password changed");
    }

    private boolean isSamePassword() {
        return changePasswordField.getText().equals(reEnterChangedPasswordField.getText());
    }

}
