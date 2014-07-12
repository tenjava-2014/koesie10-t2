package com.tenjava.entries.koesie10.t2;

import com.tenjava.entries.koesie10.t2.commands.CommandManager;
import com.tenjava.entries.koesie10.t2.commands.CreateCommand;
import com.tenjava.entries.koesie10.t2.commands.InfoCommand;
import com.tenjava.entries.koesie10.t2.commands.StartCommand;
import com.tenjava.entries.koesie10.t2.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {
    private CommandManager commandManager;
    private ArenaManager arenaManager;
    private GameManager gameManager;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);

        commandManager = new CommandManager(this);
        getCommand("minigames").setExecutor(commandManager);
        registerSubCommands();

        arenaManager = new ArenaManager(this);

        arenaManager.loadArenas();

        gameManager = new GameManager(this);
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void registerSubCommands() {
        commandManager.registerSubCommand(new InfoCommand(this));
        commandManager.registerSubCommand(new StartCommand(this));
        commandManager.registerSubCommand(new CreateCommand(this));
    }
}
