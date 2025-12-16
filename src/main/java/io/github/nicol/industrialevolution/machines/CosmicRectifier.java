package io.github.nicol.industrialevolution.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Cosmic Rectifier: Repairs "Shattered" Ethereal tools.
 * Basic implementation - full GUI logic to be added when API is confirmed.
 */
public class CosmicRectifier extends AbstractProcessingMachine {

    private static final int CAPACITY = 4096;

    public CosmicRectifier(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public String getMachineKey() {
        return "cosmic-rectifier";
    }

    @Override
    public int getEnergyConsumption() {
        return 64;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getCapacity() {
        return CAPACITY;
    }

    @Override
    protected void registerDefaultRecipes() {
        // Repairs "Shattered" Ethereal tools (logic will be custom)
    }
}
