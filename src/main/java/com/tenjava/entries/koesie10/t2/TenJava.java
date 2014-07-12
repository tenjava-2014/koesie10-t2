package com.tenjava.entries.koesie10.t2;

import com.tenjava.entries.koesie10.t2.commands.CommandManager;
import com.tenjava.entries.koesie10.t2.commands.StartCommand;
import com.tenjava.entries.koesie10.t2.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {
    private CommandManager commandManager;
    private GameManager gameManager;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);

        commandManager = new CommandManager(this);
        getCommand("murder").setExecutor(commandManager);
        registerSubCommands();

        gameManager = new GameManager(this);
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void registerSubCommands() {
        commandManager.registerSubCommand(new StartCommand(this));
    }
}
