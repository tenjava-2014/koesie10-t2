package com.tenjava.entries.koesie10.t2;

import com.tenjava.entries.koesie10.t2.api.GameModeManager;
import com.tenjava.entries.koesie10.t2.commands.CommandManager;
import com.tenjava.entries.koesie10.t2.commands.InfoCommand;
import com.tenjava.entries.koesie10.t2.commands.StartCommand;
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
        registerGameModes();

        commandManager = new CommandManager(this);
        getCommand("minigames").setExecutor(commandManager);
        registerSubCommands();
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

    public void registerSubCommands() {
        commandManager.registerSubCommand(new InfoCommand(this));
        commandManager.registerSubCommand(new StartCommand(this));
    }
}
