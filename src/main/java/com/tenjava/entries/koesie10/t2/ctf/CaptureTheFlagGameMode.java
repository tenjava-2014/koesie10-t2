package com.tenjava.entries.koesie10.t2.ctf;

public class CaptureTheFlagGameMode {

    public static String getDisplayName() {
        return "Capture The Flag";
    }

    public static String getDescription() {
        return "Use teamwork to retrieve the enemy flag to your base while defending your own flag from captures.";
    }

    public static String[] getObjectives() {
        return new String[]{
                "Capture the enemy flag by bringing it back to your base",
                "Defend your base, if the enemy team has your flag you cannot capture",
                "The first team to capture 3 flags wins"
        };
    }
}
