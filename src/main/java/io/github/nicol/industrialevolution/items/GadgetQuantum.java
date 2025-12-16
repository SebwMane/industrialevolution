package io.github.nicol.industrialevolution.items;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.nicol.industrialevolution.items.PhaseShifter;
import io.github.nicol.industrialevolution.items.GravityDisplacer;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GadgetQuantum {

        public static final SlimefunItemStack PHASE_SHIFTER = new SlimefunItemStack("IE_PHASE_SHIFTER",
                        Material.COMPASS,
                        "&bQuantum Phase Shifter", "", "&7Right-Click to blink 8 blocks forward.",
                        "&7Phases through walls.",
                        "&eCooldown: 10s");
        public static final SlimefunItemStack GRAVITY_DISPLACER = new SlimefunItemStack("IE_GRAVITY_DISPLACER",
                        Material.FEATHER, "&bGravity Displacer", "", "&7Right-Click mobs to launch them.", "&7Safely.",
                        "&eUtility");

        public static void setup(IndustrialEvolution plugin) {
                // Phase Shifter Recipe
                new PhaseShifter(CategorySetup.QUANTUM_ERA, PHASE_SHIFTER, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                MaterialQuantum.ENERGIZED_PRISMARINE, MaterialQuantum.QUANTUM_CORE,
                                                MaterialQuantum.ENERGIZED_PRISMARINE,
                                                MaterialQuantum.DENSE_CARBON_ALLOY, SlimefunItems.INFUSED_MAGNET,
                                                MaterialQuantum.DENSE_CARBON_ALLOY,
                                                MaterialQuantum.ENERGIZED_PRISMARINE, MaterialQuantum.QUANTUM_CORE,
                                                MaterialQuantum.ENERGIZED_PRISMARINE
                                }).register(plugin);

                // Gravity Displacer Recipe
                new GravityDisplacer(CategorySetup.QUANTUM_ERA, GRAVITY_DISPLACER, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                new ItemStack(Material.PHANTOM_MEMBRANE), SlimefunItems.INFUSED_MAGNET,
                                                new ItemStack(Material.PHANTOM_MEMBRANE),
                                                SlimefunItems.AIR_RUNE, MaterialQuantum.QUANTUM_CORE,
                                                SlimefunItems.AIR_RUNE,
                                                MaterialQuantum.DENSE_CARBON_ALLOY, new ItemStack(Material.FISHING_ROD),
                                                MaterialQuantum.DENSE_CARBON_ALLOY
                                }).register(plugin);
        }
}
