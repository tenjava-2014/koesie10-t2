package com.tenjava.entries.koesie10.t2.commands;

import com.tenjava.entries.koesie10.t2.TenJava;
import com.tenjava.entries.koesie10.t2.api.GameMode;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class InfoCommand extends AbstractSubCommand {
    public InfoCommand(TenJava plugin) {
        super(plugin);
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"i"};
    }

    @Override
    public String getUsage() {
        return "<name>";
    }

    @Override
    public String getPermission() {
        return "minigames.info";
    }

    @Override
    public void handleCommand(CommandSender sender, List<String> args) {
        if (args.size() < 1) {
            sender.sendMessage(ChatColor.RED + "You must supply the name of the gamemode.");
            return;
        }
        String name = "";
        for (String arg : args) {
            name += arg + " ";
        }
        GameMode gameMode = plugin.getGameModeManager().getGameModeByNameOrDisplayName(name.trim());
        if (gameMode == null) {
            plugin.getLogger().info(name);
            plugin.getLogger().info(plugin.getGameModeManager().getGameModes().toString());
            sender.sendMessage(ChatColor.RED + "Unknown gamemode.");
            return;
        }
        sender.sendMessage(ChatColor.GOLD + gameMode.getDisplayName());
        sender.sendMessage(ChatColor.WHITE + "============================");
        sender.sendMessage(ChatColor.GREEN + gameMode.getDescription());
        if (gameMode.getObjectives().length > 0) {
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "Objectives: ");
            sender.sendMessage(ChatColor.WHITE + "----------------------------");
            for (String objective : gameMode.getObjectives()) {
                sender.sendMessage(ChatColor.BLUE + "- " + objective);
            }
        }
    }
}
