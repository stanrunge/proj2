package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.repositories.UserRepository;
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
public class LoginController {

    private final UserController userController;
    private final ApplicationContext applicationContext;

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

    public LoginController(UserRepository userRepository, ApplicationContext applicationContext) {
        this.userController = new UserController(userRepository);
        this.applicationContext = applicationContext;
    }

    @FXML
    private void logIn(ActionEvent event) throws IOException {
        String username = usernameField.getText();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(passwordField.getText());

        Iterable<User> users = userController.getUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && encoder.matches(passwordField.getText(), user.getHashedPassword())) {
                DashboardController dashboardController = applicationContext.getBean(DashboardController.class);
                dashboardController.setCurrentUser(user);

                Stage stage = (Stage) registerButton.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/views/DashboardView.fxml"));
                loader.setController(dashboardController);
                loader.setControllerFactory(applicationContext::getBean);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                return;
            } else if (user.getUsername().equals(username) && !user.getHashedPassword().equals(hashedPassword)) {
                errorLabel.setText("Wrong password");
                return;
            }
        }
        errorLabel.setText("Username does not exist");
    }

    @FXML
    private void register(ActionEvent event) throws IOException {
        Stage stage = (Stage) registerButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/views/RegisterView.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }

}
