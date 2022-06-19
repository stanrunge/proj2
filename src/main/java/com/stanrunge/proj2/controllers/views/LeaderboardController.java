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

@Component
public class LeaderboardController {

    UserController userController;
    Iterable<User> users;
    ObservableList<User> userList;

    @FXML
    TableView leaderboardTable;

    @FXML
    TableColumn profilePictureColumn;

    @FXML
    TableColumn usernameColumn;

    @FXML
    TableColumn pointsColumn;

    @FXML
    private void initialize() {
        userController = JavaFXApplication.getUserController();
        users = userController.getUsers();
        for(User user : users) {
            userList.add(user);
            System.out.println(user.getUsername());
        }

        leaderboardTable.setEditable(true);
        fillTable();
    }

    private void fillTable() {
        profilePictureColumn.setCellValueFactory(new PropertyValueFactory<User, String>("profilePicture"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<User, String>("points"));
    }
}
