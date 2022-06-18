package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.JavaFXApplication;
import com.stanrunge.proj2.controllers.data.UserController;
import com.stanrunge.proj2.data.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.stereotype.Component;

@Component
public class LeaderboardController {

    UserController userController;
    Iterable<User> users;

    @FXML
    TableView<User> leaderboardTable;

    @FXML
    TableColumn<User, String> usernameColumn;

    @FXML
    private void initialize() {
        userController = JavaFXApplication.getUserController();
        users = userController.getUsers();
        leaderboardTable.setItems((ObservableList<User>) users);
    }
}
