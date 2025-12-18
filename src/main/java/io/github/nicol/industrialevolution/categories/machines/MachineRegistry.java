package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MachineRegistry {

        public static final SlimefunItemStack ISOTOPIC_CENTRIFUGE = new SlimefunItemStack("IE_ISOTOPIC_CENTRIFUGE",
                        Material.IRON_BLOCK, "&bIsotopic Centrifuge", "", "&7Refines Uranium into Plutonium",
                        "&7More efficient but slower than standard methods.", "&eMachine");
        public static final SlimefunItemStack QUANTUM_MINER = new SlimefunItemStack("IE_QUANTUM_MINER",
                        Material.NETHERITE_BLOCK, "&bQuantum-Assisted Deep Miner", "",
                        "&7Mines resources from the void.",
                        "&7High energy cost, exponentially faster.", "&eMachine");

        // Phase 2 placeholders
        public static final SlimefunItemStack SCHEMATIC_BUILDER = new SlimefunItemStack("IE_SCHEMATIC_BUILDER",
                        Material.BLUE_GLAZED_TERRACOTTA, "&bSchematic Builder", "",
                        "&7Builds structures from blueprints.",
                        "&eMachine");
        public static final SlimefunItemStack QUANTUM_STORAGE = new SlimefunItemStack("IE_QUANTUM_STORAGE",
                        Material.PURPLE_SHULKER_BOX, "&bQuantum Storage", "", "&7Massive storage network.",
                        "&eMachine");
        public static final SlimefunItemStack QUANTUM_FLUX_CONDENSER = new SlimefunItemStack(
                        "IE_QUANTUM_FLUX_CONDENSER",
                        Material.DAYLIGHT_DETECTOR, "&bQuantum Flux Condenser", "", "&7Generates energy from entropy.",
                        "&eGenerator");

        public static void setup(IndustrialEvolution plugin) {
                // Initialize Ferrum Press (Tier 1)
                FerrumPress.setup(plugin);

                // Initialize Industrial Smeltery (Tier 2)
                IndustrialSmeltery.setup(plugin);

                // Initialize Singularity Compressor (Tier 4)
                SingularityCompressor.setup(plugin);

                // Initialize Temporal Condenser (Tier 5)
                TemporalCondenser.setup(plugin);

                // Initialize Evolution Altar (Tier 6)
                EvolutionAltar.setup(plugin);

                // Isotopic Centrifuge Recipe
                new IsotopicCentrifuge(CategorySetup.MACHINES, ISOTOPIC_CENTRIFUGE, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                ResourceItems.DENSE_CARBON_ALLOY, SlimefunItems.ELECTRIC_MOTOR,
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT
                                }).register(plugin);

                // Quantum Miner Recipe
                new QuantumMiner(CategorySetup.MACHINES, QUANTUM_MINER, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                ResourceItems.DENSE_CARBON_ALLOY, ResourceItems.QUANTUM_CORE,
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.PISTON),
                                                new ItemStack(Material.IRON_BLOCK),
                                                ResourceItems.DENSE_CARBON_ALLOY, ResourceItems.QUANTUM_CORE,
                                                ResourceItems.DENSE_CARBON_ALLOY
                                }).register(plugin);

                // Schematic Builder Recipe
                new SchematicBuilder(CategorySetup.MACHINES, SCHEMATIC_BUILDER, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                SlimefunItems.HOLOGRAM_PROJECTOR, ResourceItems.QUANTUM_CORE,
                                                SlimefunItems.HOLOGRAM_PROJECTOR,
                                                new ItemStack(Material.COMPARATOR), ResourceItems.DENSE_CARBON_ALLOY,
                                                new ItemStack(Material.COMPARATOR),
                                                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.BIG_CAPACITOR,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT
                                }).register(plugin);

                // Quantum Storage Recipe
                // new QuantumStorage(CategorySetup.MACHINES, QUANTUM_STORAGE,
                // RecipeType.ENHANCED_CRAFTING_TABLE,
                // new ItemStack[] {
                // ResourceItems.ENERGIZED_PRISMARINE, ResourceItems.QUANTUM_CORE,
                // ResourceItems.ENERGIZED_PRISMARINE,
                // SlimefunItems.ANDROID_MEMORY_CORE, new ItemStack(Material.CHEST),
                // SlimefunItems.ANDROID_MEMORY_CORE,
                // ResourceItems.DENSE_CARBON_ALLOY, SlimefunItems.BLISTERING_INGOT,
                // ResourceItems.DENSE_CARBON_ALLOY
                // }).register(plugin);

                // Quantum Flux Condenser Recipe
                new QuantumFluxCondenser(CategorySetup.MACHINES, QUANTUM_FLUX_CONDENSER,
                                RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                ResourceItems.QUANTUM_CORE, SlimefunItems.SOLAR_PANEL,
                                                ResourceItems.QUANTUM_CORE,
                                                SlimefunItems.HEATING_COIL, ResourceItems.DENSE_CARBON_ALLOY,
                                                SlimefunItems.COOLING_UNIT,
                                                ResourceItems.DENSE_CARBON_ALLOY, SlimefunItems.BATTERY,
                                                ResourceItems.DENSE_CARBON_ALLOY
                                }).register(plugin);
        }
}
