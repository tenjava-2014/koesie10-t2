package com.tenjava.entries.koesie10.t2;

import org.bukkit.Location;

import java.io.Serializable;

public class Arena implements Serializable {
    private String name;
    private Location location;

    public Arena(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Arena{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
