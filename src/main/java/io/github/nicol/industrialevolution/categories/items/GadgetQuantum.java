package io.github.nicol.industrialevolution.categories.items;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
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
                new PhaseShifter(CategorySetup.ITEMS, PHASE_SHIFTER,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ResourceItems.ENERGIZED_PRISMARINE, ResourceItems.QUANTUM_CORE,
                                                ResourceItems.ENERGIZED_PRISMARINE,
                                                ResourceItems.DENSE_CARBON_ALLOY, SlimefunItems.INFUSED_MAGNET,
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                ResourceItems.ENERGIZED_PRISMARINE, ResourceItems.QUANTUM_CORE,
                                                ResourceItems.ENERGIZED_PRISMARINE
                                }).register(plugin);

                // Gravity Displacer Recipe
                new GravityDisplacer(CategorySetup.ITEMS, GRAVITY_DISPLACER,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                new ItemStack(Material.PHANTOM_MEMBRANE), SlimefunItems.INFUSED_MAGNET,
                                                new ItemStack(Material.PHANTOM_MEMBRANE),
                                                SlimefunItems.AIR_RUNE, ResourceItems.QUANTUM_CORE,
                                                SlimefunItems.AIR_RUNE,
                                                ResourceItems.DENSE_CARBON_ALLOY, new ItemStack(Material.FISHING_ROD),
                                                ResourceItems.DENSE_CARBON_ALLOY
                                }).register(plugin);
        }
}
