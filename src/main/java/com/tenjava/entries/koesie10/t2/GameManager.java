package com.tenjava.entries.koesie10.t2;

import org.bukkit.Location;

public class GameManager {
    private TenJava plugin;
    public boolean gameInProgress;
    public Location redLocation;
    public Location blueLocation;

    public GameManager(TenJava plugin) {
        this.plugin = plugin;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }
}
