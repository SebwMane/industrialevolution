package io.github.nicol.industrialevolution.core.definitions;

import org.bukkit.ChatColor;

/**
 * Defines the progression tier of a machine, item, or recipe.
 */
public enum Tier {
    FERRUM(0, "Ferrum Age", ChatColor.GRAY), // Tier 1: Basic
    INDUSTRIAL(1, "Industrial Age", ChatColor.GOLD), // Tier 2: Factories
    DIGITAL(2, "Digital Age", ChatColor.AQUA), // Tier 3: Logic/Network
    QUANTUM(3, "Quantum Age", ChatColor.LIGHT_PURPLE), // Tier 4: Physics
    SINGULARITY(4, "Singularity", ChatColor.DARK_PURPLE), // Tier 5: Black Holes
    DIVINE(5, "Divine Ascension", ChatColor.YELLOW); // Tier 6: Godhood

    private final int level;
    private final String name;
    private final ChatColor color;

    Tier(int level, String name, ChatColor color) {
        this.level = level;
        this.name = name;
        this.color = color;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }
}
