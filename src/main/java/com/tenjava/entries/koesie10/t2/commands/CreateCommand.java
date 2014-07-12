package com.tenjava.entries.koesie10.t2.commands;

import com.tenjava.entries.koesie10.t2.TenJava;
import com.tenjava.entries.koesie10.t2.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class CreateCommand extends AbstractSubCommand {
    public CreateCommand(TenJava plugin) {
        super(plugin);
    }

    @Override
    public String getName() {
        return "create";
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
    public String getDescription() {
        return "Creates a new arena at your current location with a name.";
    }

    @Override
    public String getPermission() {
        return "minigames.create";
    }

    @Override
    public void handleCommand(CommandSender sender, List<String> args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
            return;
        }
        if (args.size() < 1) {
            sender.sendMessage(ChatColor.RED + "You must supply a name!");
            return;
        }
        String name = args.get(0);
        Player p = (Player) sender;
        if (plugin.getArenaManager().getArena(name) != null) {
            sender.sendMessage(ChatColor.RED + "This arena already exists!");
            return;
        }
        Location location = p.getLocation();
        Arena arena = new Arena(name, location);
        plugin.getArenaManager().addArena(arena);
        plugin.getArenaManager().saveArenas();
        sender.sendMessage("Successfully saved arena " + name + "!");
    }
}
