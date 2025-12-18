package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.core.AbstractProcessingMachine;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import javax.annotation.Nonnull;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

public class SchematicBuilder extends AbstractProcessingMachine {

    private static final int CAPACITY = 512;

    public SchematicBuilder(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public String getMachineKey() {
        return "schematic-builder";
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
        // Logic for schematic building
    }
}
