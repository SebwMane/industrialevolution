package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.core.AbstractProcessingMachine;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class CosmicForge extends AbstractProcessingMachine {

    public CosmicForge(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public String getMachineKey() {
        return "cosmic-forge";
    }

    @Override
    public int getEnergyConsumption() {
        return 256;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getCapacity() {
        return 1024;
    }

    @Override
    protected void registerDefaultRecipes() {
        // Logic for forging high tier items (to be added)
    }
}
