package com.stanrunge.proj2;

import com.stanrunge.proj2.controllers.data.UserController;
import com.stanrunge.proj2.data.User;
import com.stanrunge.proj2.events.StageReadyEvent;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class JavaFXApplication extends Application {

    private ConfigurableApplicationContext context;
    private static User loggedInUser;
    private static SceneSwitcher sceneSwitcher;
    private static UserController userController;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        JavaFXApplication.loggedInUser = loggedInUser;
    }

    public static UserController getUserController() {
        return userController;
    }

    public static void setUserController(UserController userController) {
        JavaFXApplication.userController = userController;
    }

    public static SceneSwitcher getSceneSwitcher() {
        return sceneSwitcher;
    }

    public static void setSceneSwitcher(SceneSwitcher sceneSwitcher) {
        JavaFXApplication.sceneSwitcher = sceneSwitcher;
    }

    @Override
    public void init() {
        ApplicationContextInitializer<GenericApplicationContext> initializer =
        ac -> {
            ac.registerBean(Application.class, () -> JavaFXApplication.this);
            ac.registerBean(Parameters.class, this::getParameters);
            ac.registerBean(HostServices.class, this::getHostServices);
        };

        this.context = new SpringApplicationBuilder()
                .sources(Proj2Application.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) {
        context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() {
        this.context.close();
        Platform.exit();
    }
}
