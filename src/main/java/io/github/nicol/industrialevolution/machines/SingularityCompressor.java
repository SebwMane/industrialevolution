package io.github.nicol.industrialevolution.machines;

import io.github.nicol.industrialevolution.core.AbstractProcessingMachine;
import io.github.nicol.industrialevolution.items.MaterialSingularity;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Singularity Compressor: Compresses huge amounts of materials into
 * Singularities.
 */
public class SingularityCompressor extends AbstractProcessingMachine {

    public SingularityCompressor(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
            ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public String getMachineKey() {
        return "singularity-compressor";
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
        return 4096;
    }

    @Override
    @Nonnull
    public ItemStack getProgressBar() {
        return new ItemStack(Material.PISTON);
    }

    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(60,
                new ItemStack[] { new ItemStack(Material.DIAMOND_BLOCK, 64) },
                new ItemStack[] { MaterialSingularity.UNSTABLE_SINGULARITY });

        registerRecipe(120,
                new ItemStack[] { new ItemStack(Material.NETHERITE_BLOCK, 16) },
                new ItemStack[] { MaterialSingularity.UNSTABLE_SINGULARITY });
    }
}
