package com.tenjava.entries.koesie10.t2.listeners;

import com.tenjava.entries.koesie10.t2.TenJava;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {
    private TenJava plugin;

    public PlayerListener(TenJava plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> e.getPlayer().sendMessage("Welcome to CTF!"), 10);
    }

    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent e) {
        if (!plugin.getGameManager().isGameInProgress()) return;
        if (e.getTo().distance(plugin.getGameManager().blueLocation) < 15) {
            e.getPlayer().sendMessage("You are now in blue territory");
        }
        if (e.getTo().distance(plugin.getGameManager().redLocation) < 15) {
            e.getPlayer().sendMessage("You are now in red territory");
        }
    }
}
