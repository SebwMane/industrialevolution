package io.github.nicol.industrialevolution.core;

import io.github.nicol.industrialevolution.gui.InfoPanel;
import io.github.nicol.industrialevolution.gui.MachineGUI;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Base class for all Industrial Evolution processing machines.
 * Extends Slimefun's AContainer for automatic GUI, energy, and recipe handling.
 * Now customized with Localization and Info Panels.
 */
public abstract class AbstractProcessingMachine extends AContainer {

    protected AbstractProcessingMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
            ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    /**
     * Returns the machine's unique identifier key for localization (e.g.
     * "quantum-miner").
     */
    @Nonnull
    public abstract String getMachineKey();

    @Override
    @Nonnull
    public String getMachineIdentifier() {
        return getMachineKey().toUpperCase().replace("-", "_");
    }

    @Override
    public String getInventoryTitle() {
        // Use localized name for the inventory title
        return LanguageManager.getInstance().get("machine." + getMachineKey() + ".name");
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.FLINT_AND_STEEL);
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {
        // Add Info Button
        menu.addItem(MachineGUI.INFO_SLOT, MachineGUI.createInfoButton(getMachineKey()),
                (p, slot, item, action) -> {
                    openInfoPanel(p);
                    return false;
                });

        // Add Recipes Button
        menu.addItem(MachineGUI.RECIPES_SLOT, MachineGUI.createRecipesButton(),
                (p, slot, item, action) -> {
                    // Standard Slimefun recipe view seems hard to trigger programmatically
                    // without internal API, so we'll just show a message for now
                    // or rely on the Guide.
                    p.sendMessage("§eCheck the Slimefun Guide for recipes!");
                    return false;
                });

        // Add Energy Display (Initial)
        updateGuiStats(menu, b);
    }

    /**
     * Called every tick to process logic. We hook here to update GUI stats.
     */
    @Override
    protected void tick(Block b) {
        super.tick(b);

        // Update Energy Display every tick (or every few ticks to save perf)
        if (b.getWorld().getTime() % 20 == 0) { // Every second
            updateGuiStats(menu, b);
        }
    }

    private void updateGuiStats(BlockMenu menu, Block b) {
        if (menu.toInventory().getViewers().isEmpty())
            return; // Don't update if no one looking

        int charge = getCharge(b.getLocation());
        int capacity = getCapacity();

        menu.replaceExistingItem(MachineGUI.ENERGY_SLOT,
                MachineGUI.createEnergyDisplay(charge, capacity));
    }

    private void openInfoPanel(Player p) {
        // Create appropriate info panel
        InfoPanel panel;

        // Simple factory logic based on key
        String key = getMachineKey();
        if (key.equals("quantum-miner")) {
            panel = InfoPanel.Factory.forQuantumMiner();
        } else if (key.equals("singularity-compressor")) {
            panel = InfoPanel.Factory.forSingularityCompressor();
        } else if (key.equals("cosmic-forge")) {
            panel = InfoPanel.Factory.forCosmicForge();
        } else {
            // Default generic panel
            panel = new InfoPanel(key);
        }

        panel.open(p);
    }

    /**
     * Compatibility wrapper for registering with IndustrialEvolution plugin.
     */
    public void register(@Nonnull io.github.nicol.industrialevolution.IndustrialEvolution plugin) {
        // AContainer requires SlimefunAddon parameter
        super.register((me.mrCookieSlime.Slimefun.api.SlimefunAddon) plugin);
    }
}
