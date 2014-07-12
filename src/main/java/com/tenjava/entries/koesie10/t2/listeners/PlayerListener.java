package com.tenjava.entries.koesie10.t2.listeners;

import com.tenjava.entries.koesie10.t2.TenJava;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    private TenJava plugin;

    public PlayerListener(TenJava plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> e.getPlayer().sendMessage("Welcome to CTF!"), 10);
    }
}
