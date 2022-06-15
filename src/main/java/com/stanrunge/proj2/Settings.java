package com.stanrunge.proj2;

public class Settings {
    private static boolean instantiated = false;

    private Settings() {
        instantiated = true;
    }

    public Settings getInstance() {
        if (!instantiated) {
            return new Settings();
        }
        return null;
    }
}
