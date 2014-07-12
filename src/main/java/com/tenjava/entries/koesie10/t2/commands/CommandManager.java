package com.tenjava.entries.koesie10.t2.commands;

import com.tenjava.entries.koesie10.t2.TenJava;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.*;

public class CommandManager implements CommandExecutor {
    private Map<String, SubCommand> subCommands;
    private TenJava plugin;

    public CommandManager(TenJava plugin) {
        this.plugin = plugin;
        this.subCommands = new HashMap<>();
    }

    public void registerSubCommand(SubCommand subCommand) {
        this.subCommands.put(subCommand.getName(), subCommand);

        for (String alias : subCommand.getAliases()) {
            this.subCommands.put(alias, subCommand);
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length > 0) {
            if (subCommands.containsKey(args[0])) {
                SubCommand subCommand = subCommands.get(args[0]);
                List<String> subCommandArgs = new ArrayList<>(args.length-1);
                for (int i = 0; i < args.length; i++) {
                    if (i != 0) subCommandArgs.add(args[i]);
                }
                subCommand.handleCommand(commandSender, subCommandArgs);
                return true;
            }
        }
        commandSender.sendMessage(ChatColor.RED + "Unknown command, available commands: ");
        for (String name : subCommands.keySet()) {
            commandSender.sendMessage(ChatColor.RED + "- /" + label + " " + name);
        }
        return true;
    }
}
