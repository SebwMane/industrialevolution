package io.github.nicol.industrialevolution.items;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MaterialQuantum {

    public static final SlimefunItemStack DENSE_CARBON_ALLOY = new SlimefunItemStack("IE_DENSE_CARBON_ALLOY",
            Material.NETHERITE_INGOT, "&8Dense Carbon Alloy", "", "&7A heavy, structural alloy",
            "&7for Quantum machines.");
    public static final SlimefunItemStack QUANTUM_CORE = new SlimefunItemStack("IE_QUANTUM_CORE", Material.BEACON,
            "&bQuantum Core", "", "&7The heart of quantum automation.");
    public static final SlimefunItemStack ENERGIZED_PRISMARINE = new SlimefunItemStack("IE_ENERGIZED_PRISMARINE",
            Material.PRISMARINE_SHARD, "&bEnergized Prismarine", "", "&7Infused with raw energy",
            "&7Essential for wireless tech.");

    public static void setup(IndustrialEvolution plugin) {
        // DENSE_CARBON_ALLOY
        new SlimefunItem(CategorySetup.QUANTUM_ERA, DENSE_CARBON_ALLOY, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        SlimefunItems.COMPRESSED_CARBON, SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.SYNTHETIC_DIAMOND,
                        SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.COMPRESSED_CARBON,
                        SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.SYNTHETIC_DIAMOND, SlimefunItems.REINFORCED_ALLOY_INGOT,
                        SlimefunItems.COMPRESSED_CARBON
                }).register(plugin);

        // QUANTUM_CORE (Recipe speculation: Machine Block + Dense Carbon + Nether Star)
        new SlimefunItem(CategorySetup.QUANTUM_ERA, QUANTUM_CORE, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        DENSE_CARBON_ALLOY, new ItemStack(Material.NETHER_STAR), DENSE_CARBON_ALLOY,
                        new ItemStack(Material.NETHER_STAR), new ItemStack(Material.REDSTONE_BLOCK),
                        new ItemStack(Material.NETHER_STAR),
                        DENSE_CARBON_ALLOY, new ItemStack(Material.NETHER_STAR), DENSE_CARBON_ALLOY
                }).register(plugin);

        // ENERGIZED_PRISMARINE (Prismarine Crystals + Energy Regulator?)
        // Request says: "Prismarine Crystals infused with Energy Regulator content."
        // Let's use Energy Regulator in the recipe or simply require it in a machine?
        // Using Enhanced Crafting Table for now.
        new SlimefunItem(CategorySetup.QUANTUM_ERA, ENERGIZED_PRISMARINE, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.PRISMARINE_CRYSTALS), SlimefunItems.ENERGY_REGULATOR,
                        new ItemStack(Material.PRISMARINE_CRYSTALS),
                        null, new ItemStack(Material.PRISMARINE_CRYSTALS), null,
                        null, null, null
                }).register(plugin);
    }
}
