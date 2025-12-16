package io.github.nicol.industrialevolution.gui;

import io.github.nicol.industrialevolution.core.LanguageManager;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for creating machine GUI elements with localized text.
 * Provides info buttons, energy displays, and recipe buttons.
 */
public class MachineGUI {

    // Slot positions for GUI elements
    public static final int INFO_SLOT = 4;
    public static final int ENERGY_SLOT = 6;
    public static final int RECIPES_SLOT = 8;

    private MachineGUI() {
        // Utility class
    }

    /**
     * Creates an info button that shows machine description.
     * 
     * @param machineKey The language key for the machine (e.g., "quantum-miner")
     * @return The item stack for the info button
     */
    @Nonnull
    public static ItemStack createInfoButton(String machineKey) {
        LanguageManager lang = LanguageManager.getInstance();
        String title = lang.get("machine.info-button");
        String description = lang.get("machine." + machineKey + ".description");

        List<String> lore = new ArrayList<>();
        lore.add("");

        // Split description by newlines and add each line
        for (String line : description.split("\n")) {
            lore.add(line.trim());
        }

        return new CustomItemStack(
                Material.BOOK,
                title,
                lore.toArray(new String[0]));
    }

    /**
     * Creates an energy display item showing current and max energy.
     * 
     * @param currentEnergy Current energy stored
     * @param maxEnergy     Maximum energy capacity
     * @return The item stack for the energy display
     */
    @Nonnull
    public static ItemStack createEnergyDisplay(int currentEnergy, int maxEnergy) {
        LanguageManager lang = LanguageManager.getInstance();
        String text = lang.get("machine.energy-display", currentEnergy, maxEnergy);

        // Choose material based on energy level
        Material material;
        double ratio = (double) currentEnergy / maxEnergy;
        if (ratio > 0.5) {
            material = Material.GREEN_STAINED_GLASS_PANE;
        } else if (ratio > 0.25) {
            material = Material.YELLOW_STAINED_GLASS_PANE;
        } else {
            material = Material.RED_STAINED_GLASS_PANE;
        }

        // Create visual energy bar
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(createEnergyBar(ratio));
        lore.add("");
        lore.add("§7" + formatNumber(currentEnergy) + " / " + formatNumber(maxEnergy) + " J");

        return new CustomItemStack(
                material,
                text,
                lore.toArray(new String[0]));
    }

    /**
     * Creates a visual energy bar using block characters.
     */
    private static String createEnergyBar(double ratio) {
        int filled = (int) (ratio * 20);
        int empty = 20 - filled;

        StringBuilder bar = new StringBuilder("§8[");
        bar.append("§a");
        for (int i = 0; i < filled; i++) {
            bar.append("█");
        }
        bar.append("§7");
        for (int i = 0; i < empty; i++) {
            bar.append("░");
        }
        bar.append("§8]");

        return bar.toString();
    }

    /**
     * Creates a recipes button.
     * 
     * @return The item stack for the recipes button
     */
    @Nonnull
    public static ItemStack createRecipesButton() {
        LanguageManager lang = LanguageManager.getInstance();
        String title = lang.get("machine.recipes-button");

        return new CustomItemStack(
                Material.KNOWLEDGE_BOOK,
                title,
                "",
                "§7Click to view all recipes",
                "§7that this machine can process.");
    }

    /**
     * Creates a speed display item.
     * 
     * @param speed The current speed multiplier
     * @return The item stack for the speed display
     */
    @Nonnull
    public static ItemStack createSpeedDisplay(int speed) {
        LanguageManager lang = LanguageManager.getInstance();
        String text = lang.get("machine.speed-display", speed);

        return new CustomItemStack(
                Material.CLOCK,
                text,
                "",
                "§7Processing speed multiplier");
    }

    /**
     * Creates a decorative border item.
     * 
     * @return The item stack for borders
     */
    @Nonnull
    public static ItemStack createBorder() {
        return new CustomItemStack(
                Material.GRAY_STAINED_GLASS_PANE,
                " ");
    }

    /**
     * Creates a progress indicator item.
     * 
     * @param progress        Current progress (0-100)
     * @param progressBarItem The material to use for the progress bar
     * @return The item stack for the progress display
     */
    @Nonnull
    public static ItemStack createProgressIndicator(int progress, Material progressBarItem) {
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(createProgressBar(progress));
        lore.add("");
        lore.add("§7Progress: §e" + progress + "%");

        return new CustomItemStack(
                progressBarItem,
                "§e⚡ Processing...",
                lore.toArray(new String[0]));
    }

    /**
     * Creates a visual progress bar.
     */
    private static String createProgressBar(int percent) {
        int filled = percent / 5;
        int empty = 20 - filled;

        StringBuilder bar = new StringBuilder("§8[");
        bar.append("§e");
        for (int i = 0; i < filled; i++) {
            bar.append("▮");
        }
        bar.append("§7");
        for (int i = 0; i < empty; i++) {
            bar.append("▯");
        }
        bar.append("§8]");

        return bar.toString();
    }

    /**
     * Formats a number with K/M/B suffixes.
     */
    private static String formatNumber(int number) {
        if (number >= 1_000_000_000) {
            return String.format("%.1fB", number / 1_000_000_000.0);
        } else if (number >= 1_000_000) {
            return String.format("%.1fM", number / 1_000_000.0);
        } else if (number >= 1_000) {
            return String.format("%.1fK", number / 1_000.0);
        }
        return String.valueOf(number);
    }

    /**
     * Sends machine info to a player as chat messages.
     * 
     * @param player     The player to send info to
     * @param machineKey The language key for the machine
     */
    public static void sendMachineInfo(Player player, String machineKey) {
        LanguageManager lang = LanguageManager.getInstance();
        String name = lang.get("machine." + machineKey + ".name");
        String description = lang.get("machine." + machineKey + ".description");

        player.sendMessage("");
        player.sendMessage("§8§m                                        ");
        player.sendMessage(" " + name);
        player.sendMessage("§8§m                                        ");

        for (String line : description.split("\n")) {
            player.sendMessage(" " + line.trim());
        }

        player.sendMessage("§8§m                                        ");
        player.sendMessage("");
    }
}
