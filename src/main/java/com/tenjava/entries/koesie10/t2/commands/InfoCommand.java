package com.tenjava.entries.koesie10.t2.commands;

import com.tenjava.entries.koesie10.t2.TenJava;
import com.tenjava.entries.koesie10.t2.ctf.CaptureTheFlagGameMode;
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
        return "<gamemode>";
    }

    @Override
    public String getDescription() {
        return "Give information about the supplied gamemode.";
    }

    @Override
    public String getPermission() {
        return "minigames.info";
    }

    @Override
    public void handleCommand(CommandSender sender, List<String> args) {
        sender.sendMessage(ChatColor.GOLD + CaptureTheFlagGameMode.getDisplayName());
        sender.sendMessage(ChatColor.WHITE + "============================");
        sender.sendMessage(ChatColor.GREEN + CaptureTheFlagGameMode.getDescription());
        if (CaptureTheFlagGameMode.getObjectives().length > 0) {
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "Objectives: ");
            sender.sendMessage(ChatColor.WHITE + "----------------------------");
            for (String objective : CaptureTheFlagGameMode.getObjectives()) {
                sender.sendMessage(ChatColor.BLUE + "- " + objective);
            }
        }
    }
}
