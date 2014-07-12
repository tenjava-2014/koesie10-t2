package com.tenjava.entries.koesie10.t2.commands;

import com.tenjava.entries.koesie10.t2.TenJava;
import org.bukkit.command.CommandSender;

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
        return "<name>";
    }

    @Override
    public String getPermission() {
        return "minigames.start";
    }

    @Override
    public void handleCommand(CommandSender sender, List<String> args) {

    }
}
