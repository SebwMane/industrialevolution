package io.github.nicol.industrialevolution.categories.resources;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ResourceItems {

        // Tier 1: Ferrum Age
        public static final SlimefunItemStack FERRUM_INGOT = new SlimefunItemStack("IE_FERRUM_INGOT",
                        Material.IRON_INGOT, "&fFerrum Ingot", "", "&7Refined Iron for basic machinery.",
                        "&eTier 1 Resource");

        public static final SlimefunItemStack COMPRESSED_IRON = new SlimefunItemStack("IE_COMPRESSED_IRON",
                        Material.IRON_BLOCK, "&fCompressed Iron", "", "&7Dense iron for heavy construction.",
                        "&eTier 1 Resource");

        public static final SlimefunItemStack COMPRESSED_COBBLESTONE = new SlimefunItemStack(
                        "IE_COMPRESSED_COBBLESTONE",
                        Material.COBBLESTONE, "&fCompressed Cobblestone", "", "&79x Compressed Cobblestone.",
                        "&eTier 1 Resource");
        public static final SlimefunItemStack COMPRESSED_DIRT = new SlimefunItemStack("IE_COMPRESSED_DIRT",
                        Material.DIRT, "&fCompressed Dirt", "", "&79x Compressed Dirt.", "&eTier 1 Resource");
        public static final SlimefunItemStack COMPRESSED_GRAVEL = new SlimefunItemStack("IE_COMPRESSED_GRAVEL",
                        Material.GRAVEL, "&fCompressed Gravel", "", "&79x Compressed Gravel.", "&eTier 1 Resource");
        public static final SlimefunItemStack COMPRESSED_SAND = new SlimefunItemStack("IE_COMPRESSED_SAND",
                        Material.SAND, "&fCompressed Sand", "", "&79x Compressed Sand.", "&eTier 1 Resource");

        // Tier 6: Quantum Age (Legacy Items)
        public static final SlimefunItemStack DENSE_CARBON_ALLOY = new SlimefunItemStack("IE_DENSE_CARBON_ALLOY",
                        Material.NETHERITE_INGOT, "&8Dense Carbon Alloy", "", "&7A heavy, structural alloy",
                        "&7for Quantum machines.", "&dTier 6 Resource");
        public static final SlimefunItemStack QUANTUM_CORE = new SlimefunItemStack("IE_QUANTUM_CORE", Material.BEACON,
                        "&bQuantum Core", "", "&7The heart of quantum automation.", "&dTier 6 Resource");
        public static final SlimefunItemStack ENERGIZED_PRISMARINE = new SlimefunItemStack("IE_ENERGIZED_PRISMARINE",
                        Material.PRISMARINE_SHARD, "&bEnergized Prismarine", "", "&7Infused with raw energy",
                        "&7Essential for wireless tech.", "&dTier 6 Resource");

        public static final SlimefunItemStack TIME_CRYSTAL = new SlimefunItemStack("IE_TIME_CRYSTAL",
                        Material.AMETHYST_SHARD, "&dTime Crystal", "", "&7Crystallized temporal energy.",
                        "&7Requires 7 days to condense.", "&5Singularity Resource");

        public static void setup(IndustrialEvolution plugin) {
                // --- Tier 1 ---
                new SlimefunItem(CategorySetup.RESOURCES, FERRUM_INGOT, RecipeType.SMELTERY,
                                new ItemStack[] {
                                                new ItemStack(Material.IRON_INGOT), null, null,
                                                null, null, null,
                                                null, null, null
                                }).register(plugin);

                // Compressed Iron (9 Iron Ingots in Compressor usually, but here generic craft
                // for now)
                new CompressedResource(COMPRESSED_IRON, new ItemStack(Material.IRON_INGOT), 9,
                                RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
                                                new ItemStack(Material.IRON_INGOT),
                                                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
                                                new ItemStack(Material.IRON_INGOT),
                                                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT),
                                                new ItemStack(Material.IRON_INGOT)
                                }).register(plugin);

                // Compressed Cobblestone
                new CompressedResource(COMPRESSED_COBBLESTONE, new ItemStack(Material.COBBLESTONE), 9,
                                RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                new ItemStack(Material.COBBLESTONE),
                                                new ItemStack(Material.COBBLESTONE),
                                                new ItemStack(Material.COBBLESTONE),
                                                new ItemStack(Material.COBBLESTONE),
                                                new ItemStack(Material.COBBLESTONE),
                                                new ItemStack(Material.COBBLESTONE),
                                                new ItemStack(Material.COBBLESTONE),
                                                new ItemStack(Material.COBBLESTONE), new ItemStack(Material.COBBLESTONE)
                                }).register(plugin);

                // Compressed Dirt
                new CompressedResource(COMPRESSED_DIRT, new ItemStack(Material.DIRT), 9,
                                RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                new ItemStack(Material.DIRT), new ItemStack(Material.DIRT),
                                                new ItemStack(Material.DIRT),
                                                new ItemStack(Material.DIRT), new ItemStack(Material.DIRT),
                                                new ItemStack(Material.DIRT),
                                                new ItemStack(Material.DIRT), new ItemStack(Material.DIRT),
                                                new ItemStack(Material.DIRT)
                                }).register(plugin);

                // Compressed Gravel
                new CompressedResource(COMPRESSED_GRAVEL, new ItemStack(Material.GRAVEL), 9,
                                RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                new ItemStack(Material.GRAVEL), new ItemStack(Material.GRAVEL),
                                                new ItemStack(Material.GRAVEL),
                                                new ItemStack(Material.GRAVEL), new ItemStack(Material.GRAVEL),
                                                new ItemStack(Material.GRAVEL),
                                                new ItemStack(Material.GRAVEL), new ItemStack(Material.GRAVEL),
                                                new ItemStack(Material.GRAVEL)
                                }).register(plugin);

                // Compressed Sand
                new CompressedResource(COMPRESSED_SAND, new ItemStack(Material.SAND), 9,
                                RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                new ItemStack(Material.SAND), new ItemStack(Material.SAND),
                                                new ItemStack(Material.SAND),
                                                new ItemStack(Material.SAND), new ItemStack(Material.SAND),
                                                new ItemStack(Material.SAND),
                                                new ItemStack(Material.SAND), new ItemStack(Material.SAND),
                                                new ItemStack(Material.SAND)
                                }).register(plugin);

                // --- Tier 6 ---
                // DENSE_CARBON_ALLOY
                new SlimefunItem(CategorySetup.RESOURCES, DENSE_CARBON_ALLOY, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                SlimefunItems.COMPRESSED_CARBON, SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                SlimefunItems.SYNTHETIC_DIAMOND,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.COMPRESSED_CARBON,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                SlimefunItems.SYNTHETIC_DIAMOND, SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                SlimefunItems.COMPRESSED_CARBON
                                }).register(plugin);

                // QUANTUM_CORE
                new SlimefunItem(CategorySetup.RESOURCES, QUANTUM_CORE, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                DENSE_CARBON_ALLOY, new ItemStack(Material.NETHER_STAR),
                                                DENSE_CARBON_ALLOY,
                                                new ItemStack(Material.NETHER_STAR),
                                                new ItemStack(Material.REDSTONE_BLOCK),
                                                new ItemStack(Material.NETHER_STAR),
                                                DENSE_CARBON_ALLOY, new ItemStack(Material.NETHER_STAR),
                                                DENSE_CARBON_ALLOY
                                }).register(plugin);

                new SlimefunItem(CategorySetup.RESOURCES, ENERGIZED_PRISMARINE, RecipeType.ENHANCED_CRAFTING_TABLE,
                                new ItemStack[] {
                                                new ItemStack(Material.PRISMARINE_CRYSTALS),
                                                SlimefunItems.ENERGY_REGULATOR,
                                                new ItemStack(Material.PRISMARINE_CRYSTALS),
                                                null, new ItemStack(Material.PRISMARINE_CRYSTALS), null,
                                                null, null, null
                                }).register(plugin);

                new SlimefunItem(CategorySetup.RESOURCES, TIME_CRYSTAL, RecipeType.NULL,
                                new ItemStack[] { null, null, null, null, null, null, null, null, null })
                                .register(plugin);
        }
}
