package com.tenjava.entries.koesie10.t2.api;

import org.bukkit.Location;

public interface GameMode {
    /**
     * Creates the field on which the minigame should be played
     *
     * @param startLocation The location from where the area will be built
     */
    public void createField(Location startLocation);

    /**
     * @return Computer name for this gamemode.
     */
    public String getName();

    /**
     * @return Display name for gamemode.
     */
    public String getDisplayName();

    /**
     * @return The description of this gamemode.
     */
    public String getDescription();

    /**
     * @return The objectives of this gamemode.
     */
    public String[] getObjectives();
}
