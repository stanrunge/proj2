package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.UserRepository;
import com.stanrunge.proj2.controllers.UserController;
import com.stanrunge.proj2.data.User;
import com.stanrunge.proj2.security.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    private final UserController userController;

    @FXML
    private Label errorLabel;

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;

    public LoginController(UserRepository userRepository) {
        this.userController = new UserController(userRepository);
    }

    @FXML
    private void logIn(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        String hashedPassword = Password.hashPassword(password);

        User user = userController.getUserByUsername(username);
        if (user == null) {
            errorLabel.setText("User not found");
            return;
        }

        if (hashedPassword.equals(user.getHashedPassword())) {
            System.out.println("Logged in");
        } else {
            System.out.println("Wrong password");
            errorLabel.setText("Wrong password");
        }
    }

    @FXML
    private void register(ActionEvent event) {

    }

}
