package io.github.nicol.industrialevolution.categories.magic;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.nicol.industrialevolution.categories.resources.MaterialSingularity;
import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemEthereal {

        public static final SlimefunItemStack ETHER_ESSENCE = new SlimefunItemStack("IE_ETHER_ESSENCE",
                        Material.GLOWSTONE_DUST, "&f&lEther Essence", "", "&7Pure light distilled.",
                        "&eDivine Resource");
        public static final SlimefunItemStack CHAOS_SHARD = new SlimefunItemStack("IE_CHAOS_SHARD", Material.ECHO_SHARD,
                        "&8Chaos Shard", "", "&7Fragment of entropy.", "&cDangerous");
        public static final SlimefunItemStack VIBRANIUM_CRYSTAL = new SlimefunItemStack("IE_VIBRANIUM_CRYSTAL",
                        Material.AMETHYST_SHARD, "&d&lVibranium Crystal", "", "&7The strongest material known.",
                        "&eIndestructible Potential");
        public static final SlimefunItemStack COSMIC_INGOT = new SlimefunItemStack("IE_COSMIC_INGOT",
                        Material.NETHER_STAR, "&5&lCosmic Ingot", "", "&7Forged from starlight and void.",
                        "&eGodly Alloy");

        public static void setup(IndustrialEvolution plugin) {
                // Ether Essence (Light/Essence based)
                // Placeholder recipe until Cosmic Forge is ready
                new SlimefunItem(CategorySetup.MAGIC, ETHER_ESSENCE,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                new ItemStack(Material.GLOWSTONE_DUST),
                                                ResourceItems.ENERGIZED_PRISMARINE,
                                                new ItemStack(Material.GLOWSTONE_DUST),
                                                MaterialSingularity.MATTER_STABILIZER,
                                                SlimefunItems.GRANDMAS_WALKING_STICK,
                                                MaterialSingularity.MATTER_STABILIZER,
                                                new ItemStack(Material.GLOWSTONE_DUST),
                                                ResourceItems.ENERGIZED_PRISMARINE,
                                                new ItemStack(Material.GLOWSTONE_DUST)
                                }).register(plugin);

                // Vibranium (Rare earth)
                new SlimefunItem(CategorySetup.MAGIC, VIBRANIUM_CRYSTAL,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                MaterialSingularity.UNSTABLE_SINGULARITY,
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                new ItemStack(Material.NETHERITE_BLOCK),
                                                SlimefunItems.REINFORCED_ALLOY_INGOT,
                                                ResourceItems.DENSE_CARBON_ALLOY,
                                                MaterialSingularity.UNSTABLE_SINGULARITY,
                                                ResourceItems.DENSE_CARBON_ALLOY
                                }).register(plugin);

                // Chaos Shard (From mobs or expensive craft)
                new SlimefunItem(CategorySetup.MAGIC, CHAOS_SHARD,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                new ItemStack(Material.SCULK_CATALYST),
                                                MaterialSingularity.UNSTABLE_SINGULARITY,
                                                new ItemStack(Material.SCULK_CATALYST),
                                                MaterialSingularity.UNSTABLE_SINGULARITY, SlimefunItems.ENDER_LUMP_3,
                                                MaterialSingularity.UNSTABLE_SINGULARITY,
                                                new ItemStack(Material.SCULK_CATALYST),
                                                MaterialSingularity.UNSTABLE_SINGULARITY,
                                                new ItemStack(Material.SCULK_CATALYST)
                                }).register(plugin);

                // Cosmic Ingot (Endgame Alloy)
                new SlimefunItem(CategorySetup.MAGIC, COSMIC_INGOT,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ETHER_ESSENCE, VIBRANIUM_CRYSTAL, CHAOS_SHARD,
                                                VIBRANIUM_CRYSTAL, ResourceItems.QUANTUM_CORE, VIBRANIUM_CRYSTAL,
                                                CHAOS_SHARD, VIBRANIUM_CRYSTAL, ETHER_ESSENCE
                                }).register(plugin);
        }
}
