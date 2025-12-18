package io.github.nicol.industrialevolution.categories.items;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.nicol.industrialevolution.categories.resources.MaterialSingularity;
import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GadgetSingularity {

        public static final SlimefunItemStack BLACK_HOLE_GRENADE = new SlimefunItemStack("IE_BLACK_HOLE_GRENADE",
                        Material.ENDER_PEARL, "&5Black Hole Grenade", "", "&7Throwable vortex.",
                        "&7Sucks entities into the void.",
                        "&cConsumable");
        public static final SlimefunItemStack MATTER_DISMANTLER = new SlimefunItemStack("IE_MATTER_DISMANTLER",
                        Material.GOLDEN_PICKAXE, "&5Matter Dismantler", "", "&7Instantly deletes blocks.",
                        "&7Convert matter into XP/Energy.", "&eTool");

        public static void setup(IndustrialEvolution plugin) {
                // Black Hole Grenade
                new BlackHoleGrenade(CategorySetup.ITEMS, BLACK_HOLE_GRENADE,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                MaterialSingularity.UNSTABLE_SINGULARITY, SlimefunItems.ENDER_LUMP_3,
                                                MaterialSingularity.UNSTABLE_SINGULARITY,
                                                new ItemStack(Material.DARK_PRISMARINE), new ItemStack(Material.TNT),
                                                new ItemStack(Material.DARK_PRISMARINE),
                                                MaterialSingularity.UNSTABLE_SINGULARITY, SlimefunItems.ENDER_LUMP_3,
                                                MaterialSingularity.UNSTABLE_SINGULARITY
                                }).register(plugin);

                // Matter Dismantler
                new MatterDismantler(CategorySetup.ITEMS, MATTER_DISMANTLER,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ResourceItems.QUANTUM_CORE, MaterialSingularity.MATTER_STABILIZER,
                                                ResourceItems.QUANTUM_CORE,
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                SlimefunItems.PICKAXE_OF_CONTAINMENT,
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                new ItemStack(Material.NETHERITE_INGOT),
                                                MaterialSingularity.UNSTABLE_SINGULARITY,
                                                new ItemStack(Material.NETHERITE_INGOT)
                                }).register(plugin);
        }
}
