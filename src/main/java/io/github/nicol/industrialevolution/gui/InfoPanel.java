package io.github.nicol.industrialevolution.gui;

import io.github.nicol.industrialevolution.core.LanguageManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Info Panel for displaying detailed machine information to players.
 * Opens a separate inventory with scrollable information.
 */
public class InfoPanel {

    private static final int ROWS = 6;
    private static final int SIZE = ROWS * 9;

    private final String title;
    private final List<String> descriptionLines;
    private final List<InfoSection> sections;

    /**
     * Creates a new info panel for a machine.
     * 
     * @param machineKey The language key for the machine
     */
    public InfoPanel(String machineKey) {
        this.sections = new ArrayList<>();

        LanguageManager lang = LanguageManager.getInstance();
        this.title = lang.get("machine." + machineKey + ".name");

        String description = lang.get("machine." + machineKey + ".description");
        this.descriptionLines = new ArrayList<>();
        for (String line : description.split("\n")) {
            descriptionLines.add(line.trim());
        }
    }

    /**
     * Adds a section to the info panel.
     */
    public InfoPanel addSection(String title, Material icon, List<String> content) {
        sections.add(new InfoSection(title, icon, content));
        return this;
    }

    /**
     * Opens the info panel for a player.
     */
    public void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, SIZE, "§e❓ " + title);

        // Fill with border
        ItemStack border = createBorderItem();
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, border);
            inv.setItem(SIZE - 9 + i, border);
        }
        for (int i = 9; i < SIZE - 9; i += 9) {
            inv.setItem(i, border);
            inv.setItem(i + 8, border);
        }

        // Add title item
        inv.setItem(4, createTitleItem());

        // Add description in the center area
        int slot = 19;
        for (int i = 0; i < Math.min(descriptionLines.size(), 7); i++) {
            if (slot % 9 == 8)
                slot++; // Skip right border
            if (slot % 9 == 0)
                slot++; // Skip left border
            if (slot >= SIZE - 9)
                break; // Don't go past bottom border

            // Create a paper item with the description line
            inv.setItem(slot, createDescriptionLine(descriptionLines.get(i)));
            slot++;
        }

        // Add section icons at the bottom
        int sectionSlot = 37;
        for (InfoSection section : sections) {
            if (sectionSlot >= 44)
                break;
            inv.setItem(sectionSlot, section.toItemStack());
            sectionSlot++;
        }

        // Close button
        inv.setItem(49, createCloseButton());

        player.openInventory(inv);
    }

    /**
     * Creates the title item for the info panel.
     */
    private ItemStack createTitleItem() {
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(title);
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add("§7Industrial Evolution Machine");
            lore.add("§7Information Panel");
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        return item;
    }

    /**
     * Creates a description line item.
     */
    private ItemStack createDescriptionLine(String line) {
        // Invisible item that just shows the line as lore
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(line);
            item.setItemMeta(meta);
        }
        return item;
    }

    /**
     * Creates the border item.
     */
    private ItemStack createBorderItem() {
        ItemStack item = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(" ");
            item.setItemMeta(meta);
        }
        return item;
    }

    /**
     * Creates the close button.
     */
    private ItemStack createCloseButton() {
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§c✕ Close");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add("§7Click to close this panel");
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        return item;
    }

    /**
     * Represents a section in the info panel.
     */
    private static class InfoSection {
        private final String title;
        private final Material icon;
        private final List<String> content;

        public InfoSection(String title, Material icon, List<String> content) {
            this.title = title;
            this.icon = icon;
            this.content = content;
        }

        public ItemStack toItemStack() {
            ItemStack item = new ItemStack(icon);
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(title);
                List<String> lore = new ArrayList<>();
                lore.add("");
                lore.addAll(content);
                meta.setLore(lore);
                item.setItemMeta(meta);
            }
            return item;
        }
    }

    /**
     * Static factory methods for common machine info panels.
     */
    public static class Factory {

        public static InfoPanel forQuantumMiner() {
            InfoPanel panel = new InfoPanel("quantum-miner");

            List<String> fuelInfo = new ArrayList<>();
            fuelInfo.add("§7Coal Block → §7Common ores");
            fuelInfo.add("§aDense Carbon → §aUncommon ores");
            fuelInfo.add("§bPrismarine → §bRare ores");
            fuelInfo.add("§dQuantum Core → §dLegendary ores");
            panel.addSection("§eFuel Types", Material.COAL_BLOCK, fuelInfo);

            List<String> oreInfo = new ArrayList<>();
            oreInfo.add("§7Common: Iron, Coal, Copper");
            oreInfo.add("§aUncommon: Gold, Lapis, Redstone");
            oreInfo.add("§bRare: Diamond, Emerald");
            oreInfo.add("§dLegendary: Netherite, Quantum");
            panel.addSection("§6Possible Ores", Material.DIAMOND_ORE, oreInfo);

            return panel;
        }

        public static InfoPanel forSingularityCompressor() {
            InfoPanel panel = new InfoPanel("singularity-compressor");

            List<String> coolInfo = new ArrayList<>();
            coolInfo.add("§7Requires an Entropy Dampener");
            coolInfo.add("§7within 3 blocks to function.");
            coolInfo.add("§cWithout cooling: Machine will");
            coolInfo.add("§coverheat and take damage!");
            panel.addSection("§bCooling Required", Material.BLUE_ICE, coolInfo);

            return panel;
        }

        public static InfoPanel forCosmicForge() {
            InfoPanel panel = new InfoPanel("cosmic-forge");

            List<String> starlightInfo = new ArrayList<>();
            starlightInfo.add("§7Only generates at night");
            starlightInfo.add("§7Sky must be clear");
            starlightInfo.add("§7Rain/snow prevents generation");
            panel.addSection("§eStarlight", Material.GLOWSTONE, starlightInfo);

            return panel;
        }
    }
}
