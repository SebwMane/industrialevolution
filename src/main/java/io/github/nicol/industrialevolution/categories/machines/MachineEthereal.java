package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.categories.magic.ItemEthereal;
import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MachineEthereal {

        public static final SlimefunItemStack EVOLUTION_ALTAR = new SlimefunItemStack("IE_EVOLUTION_ALTAR",
                        Material.ENCHANTING_TABLE, "&dEvolution Altar", "", "&7Ascend your gear.",
                        "&eEthereal Machine");
        public static final SlimefunItemStack COSMIC_FORGE = new SlimefunItemStack("IE_COSMIC_FORGE",
                        Material.RESPAWN_ANCHOR, "&5Cosmic Forge", "", "&7Forges god-tier items.",
                        "&cRequires Starlight.",
                        "&eEthereal Machine");
        public static final SlimefunItemStack COSMIC_RECTIFIER = new SlimefunItemStack("IE_COSMIC_RECTIFIER",
                        Material.BEACON, "&bCosmic Rectifier", "", "&7Repairs Shattered tools.",
                        "&7Recharges Ethereal Armor.",
                        "&eEthereal Machine");

        public static void setup(IndustrialEvolution plugin) {
                // Evolution Altar
                // Evolution Altar
                // Now registered in MachineRegistry.java due to complex setup
                // new EvolutionAltar(...).register(plugin);

                // Cosmic Forge
                new CosmicForge(CategorySetup.MACHINES, COSMIC_FORGE,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ItemEthereal.CHAOS_SHARD, ItemEthereal.COSMIC_INGOT,
                                                ItemEthereal.CHAOS_SHARD,
                                                ItemEthereal.VIBRANIUM_CRYSTAL, ResourceItems.QUANTUM_CORE,
                                                ItemEthereal.VIBRANIUM_CRYSTAL,
                                                ItemEthereal.CHAOS_SHARD, ItemEthereal.COSMIC_INGOT,
                                                ItemEthereal.CHAOS_SHARD
                                }).register(plugin);

                // Cosmic Rectifier
                new CosmicRectifier(CategorySetup.MACHINES, COSMIC_RECTIFIER,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                SlimefunItems.REINFORCED_ALLOY_INGOT, ItemEthereal.ETHER_ESSENCE,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                ItemEthereal.COSMIC_INGOT, new ItemStack(Material.ANVIL),
                                                ItemEthereal.COSMIC_INGOT,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT, ItemEthereal.ETHER_ESSENCE,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT
                                }).register(plugin);
        }
}
