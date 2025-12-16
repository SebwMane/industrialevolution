package io.github.nicol.industrialevolution.machines;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.items.ItemEthereal;
import io.github.nicol.industrialevolution.items.MaterialQuantum;
import io.github.nicol.industrialevolution.items.MaterialSingularity;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MachineEthereal {

    public static final SlimefunItemStack EVOLUTION_ALTAR = new SlimefunItemStack("IE_EVOLUTION_ALTAR",
            Material.ENCHANTING_TABLE, "&dEvolution Altar", "", "&7Ascend your gear.", "&eEthereal Machine");
    public static final SlimefunItemStack COSMIC_FORGE = new SlimefunItemStack("IE_COSMIC_FORGE",
            Material.RESPAWN_ANCHOR, "&5Cosmic Forge", "", "&7Forges god-tier items.", "&cRequires Starlight.",
            "&eEthereal Machine");
    public static final SlimefunItemStack COSMIC_RECTIFIER = new SlimefunItemStack("IE_COSMIC_RECTIFIER",
            Material.BEACON, "&bCosmic Rectifier", "", "&7Repairs Shattered tools.", "&7Recharges Ethereal Armor.",
            "&eEthereal Machine");

    public static void setup(IndustrialEvolution plugin) {
        // Evolution Altar
        new EvolutionAltar(CategorySetup.INFINITY_ERA, EVOLUTION_ALTAR, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        ItemEthereal.ETHER_ESSENCE, ItemEthereal.COSMIC_INGOT, ItemEthereal.ETHER_ESSENCE,
                        ItemEthereal.VIBRANIUM_CRYSTAL, MaterialSingularity.MATTER_STABILIZER,
                        ItemEthereal.VIBRANIUM_CRYSTAL,
                        SlimefunItems.BLISTERING_INGOT_3, ItemEthereal.COSMIC_INGOT, SlimefunItems.BLISTERING_INGOT_3
                }).register(plugin);

        // Cosmic Forge
        new CosmicForge(CategorySetup.INFINITY_ERA, COSMIC_FORGE, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        ItemEthereal.CHAOS_SHARD, ItemEthereal.COSMIC_INGOT, ItemEthereal.CHAOS_SHARD,
                        ItemEthereal.VIBRANIUM_CRYSTAL, MaterialQuantum.QUANTUM_CORE, ItemEthereal.VIBRANIUM_CRYSTAL,
                        ItemEthereal.CHAOS_SHARD, ItemEthereal.COSMIC_INGOT, ItemEthereal.CHAOS_SHARD
                }).register(plugin);

        // Cosmic Rectifier
        new CosmicRectifier(CategorySetup.INFINITY_ERA, COSMIC_RECTIFIER, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        SlimefunItems.REINFORCED_ALLOY_INGOT, ItemEthereal.ETHER_ESSENCE, SlimefunItems.REINFORCED_ALLOY_INGOT,
                        ItemEthereal.COSMIC_INGOT, new ItemStack(Material.ANVIL), ItemEthereal.COSMIC_INGOT,
                        SlimefunItems.REINFORCED_ALLOY_INGOT, ItemEthereal.ETHER_ESSENCE, SlimefunItems.REINFORCED_ALLOY_INGOT
                }).register(plugin);
    }
}
