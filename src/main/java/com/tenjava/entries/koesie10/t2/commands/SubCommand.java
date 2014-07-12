package com.tenjava.entries.koesie10.t2.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface SubCommand {
    public String getName();

    public String[] getAliases();

    /**
     * @return Usage of command, only return the part after `/command <name>`
     */
    public String getUsage();

    /**
     * @return Description of the sub command.
     */
    public String getDescription();

    /**
     * @return Needed permission for command or null if everyone can execute this.
     */
    public String getPermission();

    /**
     * Handles the command
     *
     * @param sender Source of the command
     * @param args   Passed command arguments
     */
    public void handleCommand(CommandSender sender, List<String> args);
}
