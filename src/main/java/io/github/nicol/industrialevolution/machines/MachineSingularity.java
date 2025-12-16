package io.github.nicol.industrialevolution.machines;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.items.MaterialQuantum;
import io.github.nicol.industrialevolution.items.MaterialSingularity;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MachineSingularity {

        public static final SlimefunItemStack ENTROPY_DAMPENER = new SlimefunItemStack("IE_ENTROPY_DAMPENER",
                        Material.BLUE_ICE, "&bEntropy Dampener", "", "&7Cools down the Singularity Compressor.",
                        "&7Reduces energy cost.", "&eMachine");
        public static final SlimefunItemStack SINGULARITY_COMPRESSOR = new SlimefunItemStack(
                        "IE_SINGULARITY_COMPRESSOR",
                        Material.OBSIDIAN, "&5Singularity Compressor", "", "&7Compresses matter into Singularities.",
                        "&cRequires cooling.", "&eMachine");
        public static final SlimefunItemStack VOID_TRAP = new SlimefunItemStack("IE_VOID_TRAP",
                        Material.SCULK_SHRIEKER, "&5Void Trap", "", "&7Pulls nearby mobs into the void.", "&eMachine");

        public static void setup(IndustrialEvolution plugin) {
                // Entropy Dampener Recipe
                new EntropyDampener(CategorySetup.SINGULARITY_ERA, ENTROPY_DAMPENER, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.COOLING_UNIT,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                SlimefunItems.BLISTERING_INGOT, MaterialQuantum.QUANTUM_CORE,
                                                SlimefunItems.BLISTERING_INGOT,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.COOLING_UNIT,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT
                                }).register(plugin);

                // Singularity Compressor Recipe
                new SingularityCompressor(CategorySetup.SINGULARITY_ERA, SINGULARITY_COMPRESSOR,
                                RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                MaterialSingularity.MATTER_STABILIZER, MaterialQuantum.QUANTUM_CORE,
                                                MaterialSingularity.MATTER_STABILIZER,
                                                MaterialQuantum.DENSE_CARBON_ALLOY, ENTROPY_DAMPENER,
                                                MaterialQuantum.DENSE_CARBON_ALLOY,
                                                MaterialSingularity.MATTER_STABILIZER, MaterialQuantum.QUANTUM_CORE,
                                                MaterialSingularity.MATTER_STABILIZER
                                }).register(plugin);

                // Void Trap Recipe
                new VoidTrap(CategorySetup.SINGULARITY_ERA, VOID_TRAP, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                SlimefunItems.INFUSED_MAGNET, MaterialSingularity.UNSTABLE_SINGULARITY,
                                                SlimefunItems.INFUSED_MAGNET,
                                                MaterialQuantum.DENSE_CARBON_ALLOY, ENTROPY_DAMPENER,
                                                MaterialQuantum.DENSE_CARBON_ALLOY,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                MaterialSingularity.UNSTABLE_SINGULARITY, SlimefunItems.REINFORCED_ALLOY_INGOT
                                }).register(plugin);
        }
}
