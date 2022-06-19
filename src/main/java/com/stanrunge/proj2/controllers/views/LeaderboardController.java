package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.JavaFXApplication;
import com.stanrunge.proj2.controllers.data.UserController;
import com.stanrunge.proj2.data.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class LeaderboardController {

    UserController userController;
    Iterable<User> users;
    ObservableList<User> userList;

    @FXML
    TableView<User> leaderboardTable;

    @FXML
    TableColumn<User, String> usernameColumn;

    @FXML
    TableColumn<User, String> pointsColumn;

    @FXML
    private void initialize() {
        userController = JavaFXApplication.getUserController();
        users = userController.getUsers();
        userList = leaderboardTable.getItems();
        for(User user : users) {
            userList.add(user);
        }

        leaderboardTable.setEditable(true);

        fillTable();

        // Sort the table by points
        leaderboardTable.getSortOrder().add(pointsColumn);
        Collections.reverse(leaderboardTable.getItems());
    }

    private void fillTable() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
    }
}
