package com.tenjava.entries.koesie10.t2.listeners;

import com.tenjava.entries.koesie10.t2.TenJava;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    private TenJava plugin;

    public PlayerListener(TenJava plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        if (!plugin.getGameManager().isGameInProgress()) return;

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.hidePlayer(e.getPlayer());
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> e.getPlayer().sendMessage("You will be able to join the next time we start!"), 10);
    }

    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent e) {
        if (!plugin.getGameManager().isGameInProgress()) return;
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            e.setCancelled(true);
            return;
        }
        Player damaged = (Player) e.getEntity();
        Player damager = (Player) e.getDamager();
        if (plugin.getGameManager().isMurderer(damager)) {
            damaged.damage(100.0);
        }
    }

    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent e) {
        if (!plugin.getGameManager().isGameInProgress()) return;
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR) && !(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getItem().getType() == Material.SNOW_BALL) {
            e.getPlayer().launchProjectile(Snowball.class);
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if (!plugin.getGameManager().isGameInProgress()) return;
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Snowball)) {
            return;
        }
        Player damaged = (Player) e.getEntity();
        Snowball snowball = (Snowball) e.getDamager();

        if (!(snowball.getShooter() instanceof Player)) return;
        Player damager = (Player) snowball.getShooter();

        if (plugin.getGameManager().isHasGun(damager) && plugin.getGameManager().isMurderer(damaged)) {
            damaged.damage(damaged.getMaxHealth());
        } else if (plugin.getGameManager().isHasGun(damager)) {
            damaged.damage(damaged.getMaxHealth());
        }
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        if (!plugin.getGameManager().isGameInProgress()) return;
        if (plugin.getGameManager().isMurderer(e.getEntity())) {
            plugin.getGameManager().bystandersWin();
        } else {
            boolean stillAlive = false;
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!plugin.getGameManager().isParticipating(player)) continue;
                stillAlive = stillAlive || !plugin.getGameManager().isDead(player);
            }
            if (!stillAlive) {
                plugin.getGameManager().murdererWins();
            }
        }
    }

    @EventHandler
    public void onEntityRegainHealth(EntityRegainHealthEvent e) {
        if (!plugin.getGameManager().isGameInProgress()) return;
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            e.setAmount(0.0);
            e.setCancelled(true);
        }
    }
}
