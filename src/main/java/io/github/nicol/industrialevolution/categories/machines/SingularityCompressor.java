package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.categories.resources.MaterialSingularity;
import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.nicol.industrialevolution.core.interfaces.EvolutionMachine;

import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Singularity Compressor: Compresses huge amounts of materials into
 * Singularities.
 * Tier 4 Machine.
 */
public class SingularityCompressor extends EvolutionMachine {

    public static final SlimefunItemStack SINGULARITY_COMPRESSOR = new SlimefunItemStack("IE_SINGULARITY_COMPRESSOR",
            Material.PISTON, "&5Singularity Compressor", "", "&7Compresses matter into unstable singularities.",
            "&dQuantum Tier Machine");

    public SingularityCompressor(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
            ItemStack[] recipe) {
        // Use custom recipe type for processing inside this machine
        super(itemGroup, item, recipeType, recipe, Tier.QUANTUM);
    }

    // Override the constructor used in setup if different
    public SingularityCompressor() {
        this(CategorySetup.MACHINES, SINGULARITY_COMPRESSOR, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        ResourceItems.DENSE_CARBON_ALLOY, ResourceItems.QUANTUM_CORE, ResourceItems.DENSE_CARBON_ALLOY,
                        new ItemStack(Material.NETHERITE_BLOCK), new ItemStack(Material.PISTON),
                        new ItemStack(Material.NETHERITE_BLOCK),
                        ResourceItems.DENSE_CARBON_ALLOY, ResourceItems.QUANTUM_CORE, ResourceItems.DENSE_CARBON_ALLOY
                });
    }

    @Override
    @Nonnull
    public String getMachineKey() {
        return "singularity-compressor";
    }

    @Override
    public int getEnergyConsumption() {
        return 512;
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
        // Example Recipes
        // 64x Compressed Diamond -> Singularity?
        // Note: Compressed items are usually 9x. 64x would be a lot.
        // Let's use 64x Blocks.
        registerRecipe(60,
                new ItemStack[] { new ItemStack(Material.DIAMOND_BLOCK, 64) },
                new ItemStack[] { MaterialSingularity.UNSTABLE_SINGULARITY });

        registerRecipe(120,
                new ItemStack[] { new ItemStack(Material.NETHERITE_BLOCK, 16) },
                new ItemStack[] { MaterialSingularity.UNSTABLE_SINGULARITY });

        // Add recipes for IE Compressed items
        // 64x Compressed Iron?
        if (ResourceItems.COMPRESSED_IRON != null) {
            registerRecipe(60,
                    new ItemStack[] { new SlimefunItemStack(ResourceItems.COMPRESSED_IRON, 64) },
                    new ItemStack[] { MaterialSingularity.UNSTABLE_SINGULARITY });
        }
    }

    public static void setup(io.github.nicol.industrialevolution.IndustrialEvolution plugin) {
        new SingularityCompressor().register(plugin);
    }
}
