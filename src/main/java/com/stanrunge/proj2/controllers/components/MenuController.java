package com.stanrunge.proj2.controllers.components;

import com.stanrunge.proj2.JavaFXApplication;
import com.stanrunge.proj2.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MenuController {

    private final ApplicationContext applicationContext;
    private final SceneSwitcher sceneSwitcher;

    public MenuController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        JavaFXApplication.setSceneSwitcher(new SceneSwitcher(applicationContext));
        sceneSwitcher = JavaFXApplication.getSceneSwitcher();
    }

    @FXML
    private Stage getStage() {
        return (Stage) accountButton.getScene().getWindow();
    }

    @FXML
    private Button accountButton;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button leaderboardButton;

    @FXML
    private Button rewardsButton;

    @FXML
    private Button settingsButton;

    @FXML
    private void switchToAccount(ActionEvent event) throws IOException {
        sceneSwitcher.switchScene(getStage(), "/fxml/views/AccountView.fxml");
    }

    @FXML
    private void switchToDashboard(ActionEvent event) throws IOException {
        sceneSwitcher.switchScene(getStage(), "/fxml/views/DashboardView.fxml");
    }

    @FXML
    private void switchToLeaderboard(ActionEvent event) throws IOException {
        sceneSwitcher.switchScene(getStage(), "/fxml/views/LeaderboardView.fxml");
    }

    @FXML
    private void switchToRewards(ActionEvent event) throws IOException {
        sceneSwitcher.switchScene(getStage(), "/fxml/views/RewardsView.fxml");
    }

    @FXML
    private void switchToSettings(ActionEvent event) throws IOException {
        sceneSwitcher.switchScene(getStage(), "/fxml/views/SettingsView.fxml");
    }

}
