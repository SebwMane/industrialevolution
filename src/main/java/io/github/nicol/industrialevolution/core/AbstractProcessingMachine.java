package io.github.nicol.industrialevolution.core;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
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


}
