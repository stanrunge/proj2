package com.stanrunge.proj2.controllers.components;

import com.stanrunge.proj2.controllers.views.DashboardController;
import com.stanrunge.proj2.data.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

public class MenuController {

    ApplicationContext applicationContext;
    User user;

//    void changeView() {
//        DashboardController dashboardController = applicationContext.getBean(DashboardController.class);
//        dashboardController.setCurrentUser(user);
//
//        Stage stage = (Stage) registerButton.getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/views/DashboardView.fxml"));
//        loader.setController(dashboardController);
//        loader.setControllerFactory(applicationContext::getBean);
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//    }

}
