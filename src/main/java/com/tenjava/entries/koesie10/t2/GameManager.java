package com.tenjava.entries.koesie10.t2;

public class GameManager {
    private TenJava plugin;
    private boolean gameInProgress;

    public GameManager(TenJava plugin) {
        this.plugin = plugin;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }
}
