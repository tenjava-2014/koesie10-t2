package com.tenjava.entries.koesie10.t2.commands;

import com.tenjava.entries.koesie10.t2.TenJava;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SetCommand extends AbstractSubCommand {
    public SetCommand(TenJava plugin) {
        super(plugin);
    }

    @Override
    public String getName() {
        return "set";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getUsage() {
        return "<blue|red>";
    }

    @Override
    public String getDescription() {
        return "Set blue or red";
    }

    @Override
    public String getPermission() {
        return "minigames.set";
    }

    @Override
    public void handleCommand(CommandSender sender, List<String> args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must run this command as player.");
            return;
        }

        if (args.size() < 1) {
            sender.sendMessage("Please supply an argument");
            return;
        }

        Player p = (Player) sender;
        String team = args.get(0);
        if (team.equalsIgnoreCase("blue")) {
            plugin.getGameManager().blueLocation = p.getLocation();
            sender.sendMessage("Set blue flag");
        } else if (team.equalsIgnoreCase("red")) {
            plugin.getGameManager().redLocation = p.getLocation();
            sender.sendMessage("Set red flag");
        } else {
            sender.sendMessage("Please supply red or blue as argument");
        }
    }
}
