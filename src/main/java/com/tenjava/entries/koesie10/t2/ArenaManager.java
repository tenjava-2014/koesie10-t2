package com.tenjava.entries.koesie10.t2;

import java.util.ArrayList;
import java.util.List;

public class ArenaManager {
    private TenJava plugin;
    private List<Arena> arenas;

    public ArenaManager(TenJava plugin) {
        this.plugin = plugin;
        this.arenas = new ArrayList<>();
    }

    /**
     * Not implemented yet
     */
    public void loadArenas() {

    }

    /**
     * Not implemented yet
     */
    public void saveArenas() {

    }

    public List<Arena> getArenas() {
        return arenas;
    }

    public Arena getArena(String name) {
        for (Arena arena : arenas) {
            if (arena.getName().equalsIgnoreCase(name)) {
                return arena;
            }
        }
        return null;
    }

    public void addArena(Arena arena) {
        arenas.add(arena);
    }
}
