package io.github.nicol.industrialevolution.machines;

import io.github.nicol.industrialevolution.core.AbstractProcessingMachine;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Isotopic Centrifuge: Processes Uranium into Plutonium/Enriched materials.
 */
public class IsotopicCentrifuge extends AbstractProcessingMachine {

    public IsotopicCentrifuge(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public String getMachineKey() {
        return "isotopic-centrifuge";
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
        return 1024;
    }

    @Override
    @Nonnull
    public ItemStack getProgressBar() {
        return new ItemStack(Material.IRON_PICKAXE);
    }

    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(10,
                new ItemStack[] { SlimefunItems.URANIUM },
                new ItemStack[] { SlimefunItems.NEPTUNIUM });

        registerRecipe(20,
                new ItemStack[] { SlimefunItems.NEPTUNIUM },
                new ItemStack[] { SlimefunItems.PLUTONIUM });

        registerRecipe(15,
                new ItemStack[] { SlimefunItems.BOOSTED_URANIUM },
                new ItemStack[] { SlimefunItems.PLUTONIUM, SlimefunItems.NEPTUNIUM });
    }
}
