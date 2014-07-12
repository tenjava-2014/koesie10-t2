package com.tenjava.entries.koesie10.t2;

import com.tenjava.entries.koesie10.t2.api.GameModeManager;
import com.tenjava.entries.koesie10.t2.commands.CommandManager;
import com.tenjava.entries.koesie10.t2.commands.GameModeInfoCommand;
import com.tenjava.entries.koesie10.t2.ctf.CaptureTheFlagGameMode;
import com.tenjava.entries.koesie10.t2.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {
    private GameModeManager gameModeManager;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);

        gameModeManager = new GameModeManager(this);
        commandManager = new CommandManager(this);

        registerGameModes();

        getCommand("minigames").setExecutor(commandManager);

        commandManager.registerSubCommand(new GameModeInfoCommand(this));
    }

    public GameModeManager getGameModeManager() {
        return gameModeManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void registerGameModes() {
        gameModeManager.addGameMode(new CaptureTheFlagGameMode());
    }
}
