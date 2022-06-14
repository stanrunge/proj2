package com.stanrunge.proj2;

public enum Scenes {
    LOGIN("/fxml/login.fxml"),
    REGISTER("/fxml/views/RegisterView.fxml");

    private final String path;

    Scenes(String s) {
        this.path = s;
    }
}
