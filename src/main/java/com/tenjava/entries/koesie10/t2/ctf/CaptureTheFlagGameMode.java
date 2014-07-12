package com.tenjava.entries.koesie10.t2.ctf;

import com.tenjava.entries.koesie10.t2.api.GameMode;
import org.bukkit.Location;

public class CaptureTheFlagGameMode implements GameMode {
    @Override
    public void createField(Location startLocation) {
        
    }

    @Override
    public String getName() {
        return "Capture The Flag";
    }

    @Override
    public String getDescription() {
        return "Use teamwork to retrieve the enemy flag to your base while defending your own flag from captures.";
    }

    @Override
    public String[] getObjectives() {
        return new String[]{
                "Capture the enemy flag by bringing it back to your base",
                "Defend your base, if the enemy team has your flag you cannot capture",
                "The first team to capture 3 flags wins"
        };
    }
}
