package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.controllers.data.UserController;
import com.stanrunge.proj2.data.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RegisterController {

    private final UserController userController;
    private final ApplicationContext applicationContext;

    public RegisterController(UserController userController, ApplicationContext applicationContext) {
        this.userController = userController;
        this.applicationContext = applicationContext;
    }

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField reEnterPasswordField;

    @FXML
    private Button registerButton;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private void register(ActionEvent event) throws IOException {
        if (!isSamePassword()) {
            errorLabel.setText("Passwords do not match");
            return;
        }

        Iterable<User> users = userController.getUsers();
        for (User user : users) {
            if (user.getUsername().equals(usernameField.getText())) {
                errorLabel.setText("Username already exists");
                return;
            }
        }

        for (User user : users) {
            if (user.getEmail().equals(emailField.getText())) {
                errorLabel.setText("Email already exists");
                return;
            }
        }

        String username = usernameField.getText();
        String hashedPassword = new BCryptPasswordEncoder().encode(passwordField.getText());
        String email = emailField.getText();

        User newUser = new User(username, hashedPassword, email);
        userController.createUser(newUser);

        Stage stage = (Stage) registerButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/views/LoginView.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }

    private boolean isSamePassword() {
        return passwordField.getText().equals(reEnterPasswordField.getText());
    }
}
