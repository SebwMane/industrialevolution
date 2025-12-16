package io.github.nicol.industrialevolution.items;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MaterialSingularity {

        public static final SlimefunItemStack MATTER_STABILIZER = new SlimefunItemStack("IE_MATTER_STABILIZER",
                        Material.LODESTONE, "&5Matter Stabilizer", "", "&7Required to stabilize Singularities.",
                        "&7Prevents implosion.");
        public static final SlimefunItemStack UNSTABLE_SINGULARITY = new SlimefunItemStack("IE_UNSTABLE_SINGULARITY",
                        Material.CRYING_OBSIDIAN, "&5Unstable Singularity", "", "&7Highly volatile matter.",
                        "&cWARNING: Decays if not used!", "&7Expires in 1 hour.");

        public static void setup(IndustrialEvolution plugin) {
                // Matter Stabilizer Recipe
                new SlimefunItem(CategorySetup.SINGULARITY_ERA, MATTER_STABILIZER, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                new ItemStack(Material.IRON_BLOCK), MaterialQuantum.QUANTUM_CORE,
                                                new ItemStack(Material.IRON_BLOCK),
                                                MaterialQuantum.DENSE_CARBON_ALLOY, SlimefunItems.BLISTERING_INGOT,
                                                MaterialQuantum.DENSE_CARBON_ALLOY,
                                                new ItemStack(Material.IRON_BLOCK), MaterialQuantum.QUANTUM_CORE,
                                                new ItemStack(Material.IRON_BLOCK)
                                }).register(plugin);

                // Unstable Singularity doesn't have a craft recipe, it's produced by the
                // Compressor.
                // But we register it here to be an item.
                new SlimefunItem(CategorySetup.SINGULARITY_ERA, UNSTABLE_SINGULARITY, RecipeType.NULL,
                                new ItemStack[] { null, null, null, null, null, null, null, null, null })
                                .register(plugin);
        }
}
