package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.core.AbstractProcessingMachine;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Void Trap: Pulls nearby mobs towards itself.
 * Basic implementation - BlockTicker logic to be added when API is confirmed.
 */
public class VoidTrap extends AbstractProcessingMachine {

    private static final int CAPACITY = 256;

    public VoidTrap(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public String getMachineKey() {
        return "void-trap";
    }

    @Override
    public int getEnergyConsumption() {
        return 128; // Active consumption when trapping
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
        // Logic for trapping mobs
    }
}
