package com.tenjava.entries.koesie10.t2;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameManager {
    private TenJava plugin;
    public boolean gameInProgress;
    public Map<String, Metadata> metadataMap;

    public GameManager(TenJava plugin) {
        this.plugin = plugin;
        this.metadataMap = new HashMap<>();
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public void start() {
        Random random = new Random();
        Player[] players = Bukkit.getOnlinePlayers();
        int murdererIndex = random.nextInt(players.length);
        int gunIndex = murdererIndex;
        while (gunIndex == murdererIndex) {
            gunIndex = random.nextInt(players.length);
        }
        Player murderer = players[murdererIndex];
        Player gun = players[gunIndex];
        this.metadataMap.put(murderer.getName(), new Metadata(true, false));
        this.metadataMap.put(gun.getName(), new Metadata(false, true));

        for (Player player : players) {
            for (Player player1 : players) {
                player.showPlayer(player1);
            }
            player.getInventory().clear();
            if (murderer.getUniqueId().equals(player.getUniqueId())) {
                player.sendMessage(ChatColor.RED + "You are the murderer!");
                player.sendMessage(ChatColor.RED + "Kill everyone and don't get caught.");
            } else if (gun.getUniqueId().equals(player.getUniqueId())) {
                player.sendMessage(ChatColor.BLUE + "You are a bystander...");
                player.sendMessage(ChatColor.BLUE + "with a secret weapon.");
                player.sendMessage(ChatColor.BLUE + "Find the murderer and kill him.");
            } else {
                player.sendMessage(ChatColor.BLUE + "You are a bystander");
                player.sendMessage(ChatColor.BLUE + "There is a murderer on the loose!");
                player.sendMessage(ChatColor.BLUE + "Don't get caught.");
            }
            if (!this.metadataMap.containsKey(player.getName())) {
                this.metadataMap.put(player.getName(), new Metadata(false, false));
            }
        }

        murderer.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
        murderer.getInventory().setHeldItemSlot(2);
        gun.getInventory().addItem(new ItemStack(Material.SNOW_BALL));
        gun.getInventory().setHeldItemSlot(2);
    }

    public boolean isParticipating(Player p) {
        return metadataMap.containsKey(p.getName());
    }

    public boolean isMurderer(Player p) {
        if (!isParticipating(p)) return false;
        return metadataMap.get(p.getName()).isMurderer();
    }

    public boolean isHasGun(Player p) {
        if (!isParticipating(p)) return false;
        return metadataMap.get(p.getName()).isHasGun();
    }

    public boolean isDead(Player p) {
        if (!isParticipating(p)) return false;
        return metadataMap.get(p.getName()).isDead();
    }

    public void bystandersWin() {
        Bukkit.getServer().broadcastMessage("Bystanders win!");
    }

    public void shotInnocentBystander(Player shooter) {
        Bukkit.getServer().broadcastMessage(shooter.getName() + " shot an innocent bystander!");
    }

    public void murdererWins() {

    }
}
