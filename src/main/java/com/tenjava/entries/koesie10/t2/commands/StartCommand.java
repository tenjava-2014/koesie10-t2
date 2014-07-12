package com.tenjava.entries.koesie10.t2.commands;

import com.tenjava.entries.koesie10.t2.TenJava;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class StartCommand extends AbstractSubCommand {
    public StartCommand(TenJava plugin) {
        super(plugin);
    }

    @Override
    public String getName() {
        return "start";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getUsage() {
        return "";
    }

    @Override
    public String getDescription() {
        return "Starts a new game.";
    }

    @Override
    public String getPermission() {
        return "murder.start";
    }

    @Override
    public void handleCommand(CommandSender sender, List<String> args) {
        if (Bukkit.getOnlinePlayers().length < 2) {
            sender.sendMessage(ChatColor.RED + "You need at least 2 players!");
            return;
        }
        plugin.getGameManager().start();
    }
}
