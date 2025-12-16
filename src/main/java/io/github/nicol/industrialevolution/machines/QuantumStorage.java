package io.github.nicol.industrialevolution.machines;

import io.github.nicol.industrialevolution.core.AbstractProcessingMachine;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Quantum Storage: A massive storage system.
 * Basic implementation - full GUI logic to be added when API is confirmed.
 */
public class QuantumStorage extends AbstractProcessingMachine {

    private static final int CAPACITY = 512;

    public QuantumStorage(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public String getMachineKey() {
        return "quantum-storage";
    }

    @Override
    public int getEnergyConsumption() {
        return 32;
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
        // Logic for storage
    }
}
