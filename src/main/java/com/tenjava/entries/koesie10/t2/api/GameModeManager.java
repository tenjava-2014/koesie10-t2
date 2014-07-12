package com.tenjava.entries.koesie10.t2.api;

import com.tenjava.entries.koesie10.t2.TenJava;

import java.util.ArrayList;
import java.util.List;

public class GameModeManager {
    private List<GameMode> gameModes;
    private TenJava plugin;

    public GameModeManager(TenJava plugin) {
        this.plugin = plugin;
        this.gameModes = new ArrayList<>();
    }

    public GameMode getGameMode(String name) {
        for (GameMode gameMode : gameModes) {
            if (gameMode.getName().equals(name)) return gameMode;
        }
        return null;
    }

    public GameMode getGameMode(Class<? extends GameMode> clazz) {
        for (GameMode gameMode : gameModes) {
            if (gameMode.getClass().equals(clazz)) return gameMode;
        }
        return null;
    }

    public GameMode getGameModeByDisplayName(String name) {
        for (GameMode gameMode : gameModes) {
            if (gameMode.getDisplayName().equalsIgnoreCase(name)) return gameMode;
        }
        return null;
    }

    public GameMode getGameModeByNameOrDisplayName(String name) {
        GameMode gameMode = getGameMode(name);
        if (gameMode == null) gameMode = getGameModeByDisplayName(name);
        return gameMode;
    }

    public List<GameMode> getGameModes() {
        return gameModes;
    }

    public void addGameMode(GameMode gameMode) {
        gameModes.add(gameMode);
    }
}
