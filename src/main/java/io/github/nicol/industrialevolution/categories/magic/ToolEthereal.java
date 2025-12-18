package io.github.nicol.industrialevolution.categories.magic;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ToolEthereal {

        public static final SlimefunItemStack CHAOS_SCYTHE = new SlimefunItemStack("IE_CHAOS_SCYTHE",
                        Material.NETHERITE_HOE, "&8Chaos Scythe", "", "&7Harvests souls and crops alike.",
                        "&cAbility: Chaos Wave (Right Click)", "&eGodly Weapon");
        public static final SlimefunItemStack VIBRANIUM_DRILL = new SlimefunItemStack("IE_VIBRANIUM_DRILL",
                        Material.PRISMARINE_SHARD, "&d&lVibranium Drill", "", "&7Mines a 3x3 area.", "&7Fortune V",
                        "&eGodly Tool");
        public static final SlimefunItemStack STAFF_OF_TIME = new SlimefunItemStack("IE_STAFF_OF_TIME", Material.CLOCK,
                        "&eStaff of Time", "", "&7Right-Click a machine to speed it up.", "&cConsumes Ether Essence.",
                        "&eUtility");

        public static final SlimefunItemStack ETHEREAL_HELMET = new SlimefunItemStack("IE_ETHEREAL_HELMET",
                        Material.NETHERITE_HELMET, "&bEthereal Helmet", "", "&7Part of the Ethereal Set.",
                        "&eTier 8 Armor");
        public static final SlimefunItemStack ETHEREAL_CHESTPLATE = new SlimefunItemStack("IE_ETHEREAL_CHESTPLATE",
                        Material.NETHERITE_CHESTPLATE, "&bEthereal Chestplate", "", "&7Part of the Ethereal Set.",
                        "&eTier 8 Armor");
        public static final SlimefunItemStack ETHEREAL_LEGGINGS = new SlimefunItemStack("IE_ETHEREAL_LEGGINGS",
                        Material.NETHERITE_LEGGINGS, "&bEthereal Leggings", "", "&7Part of the Ethereal Set.",
                        "&eTier 8 Armor");
        public static final SlimefunItemStack ETHEREAL_BOOTS = new SlimefunItemStack("IE_ETHEREAL_BOOTS",
                        Material.NETHERITE_BOOTS, "&bEthereal Boots", "", "&7Part of the Ethereal Set.",
                        "&eTier 8 Armor");

        public static void setup(IndustrialEvolution plugin) {
                // Chaos Scythe
                new ChaosScythe(CategorySetup.MAGIC, CHAOS_SCYTHE,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ItemEthereal.CHAOS_SHARD, ItemEthereal.COSMIC_INGOT,
                                                ItemEthereal.CHAOS_SHARD,
                                                ItemEthereal.COSMIC_INGOT, ItemEthereal.VIBRANIUM_CRYSTAL,
                                                ItemEthereal.COSMIC_INGOT,
                                                null, ItemEthereal.VIBRANIUM_CRYSTAL, null
                                }).register(plugin);

                // Vibranium Drill
                new VibraniumDrill(CategorySetup.MAGIC, VIBRANIUM_DRILL,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ItemEthereal.VIBRANIUM_CRYSTAL, ItemEthereal.VIBRANIUM_CRYSTAL,
                                                ItemEthereal.VIBRANIUM_CRYSTAL,
                                                ItemEthereal.VIBRANIUM_CRYSTAL, ResourceItems.QUANTUM_CORE,
                                                ItemEthereal.VIBRANIUM_CRYSTAL,
                                                null, SlimefunItems.ELECTRIC_MOTOR, null
                                }).register(plugin);

                // Staff of Time
                new StaffOfTime(CategorySetup.MAGIC, STAFF_OF_TIME,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ItemEthereal.ETHER_ESSENCE, new ItemStack(Material.CLOCK),
                                                ItemEthereal.ETHER_ESSENCE,
                                                ItemEthereal.COSMIC_INGOT, ItemEthereal.VIBRANIUM_CRYSTAL,
                                                ItemEthereal.COSMIC_INGOT,
                                                null, ItemEthereal.VIBRANIUM_CRYSTAL, null
                                }).register(plugin);

                // Ethereal Armor
                new EtherealArmor(CategorySetup.MAGIC, ETHEREAL_HELMET,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ItemEthereal.ETHER_ESSENCE, ItemEthereal.COSMIC_INGOT,
                                                ItemEthereal.ETHER_ESSENCE,
                                                ItemEthereal.COSMIC_INGOT, new ItemStack(Material.NETHERITE_HELMET),
                                                ItemEthereal.COSMIC_INGOT,
                                                null, ItemEthereal.VIBRANIUM_CRYSTAL, null
                                }).register(plugin);

                new EtherealArmor(CategorySetup.MAGIC, ETHEREAL_CHESTPLATE,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ItemEthereal.ETHER_ESSENCE, ItemEthereal.COSMIC_INGOT,
                                                ItemEthereal.ETHER_ESSENCE,
                                                ItemEthereal.COSMIC_INGOT, new ItemStack(Material.NETHERITE_CHESTPLATE),
                                                ItemEthereal.COSMIC_INGOT,
                                                ItemEthereal.VIBRANIUM_CRYSTAL, ItemEthereal.VIBRANIUM_CRYSTAL,
                                                ItemEthereal.VIBRANIUM_CRYSTAL
                                }).register(plugin);

                new EtherealArmor(CategorySetup.MAGIC, ETHEREAL_LEGGINGS,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ItemEthereal.ETHER_ESSENCE, ItemEthereal.COSMIC_INGOT,
                                                ItemEthereal.ETHER_ESSENCE,
                                                ItemEthereal.COSMIC_INGOT, new ItemStack(Material.NETHERITE_LEGGINGS),
                                                ItemEthereal.COSMIC_INGOT,
                                                null, ItemEthereal.VIBRANIUM_CRYSTAL, null
                                }).register(plugin);

                new EtherealArmor(CategorySetup.MAGIC, ETHEREAL_BOOTS,
                                io.github.nicol.industrialevolution.core.recipes.CoreRecipes.EVOLUTION_ALTAR_RECIPE,
                                new ItemStack[] {
                                                ItemEthereal.ETHER_ESSENCE, ItemEthereal.COSMIC_INGOT,
                                                ItemEthereal.ETHER_ESSENCE,
                                                ItemEthereal.COSMIC_INGOT, new ItemStack(Material.NETHERITE_BOOTS),
                                                ItemEthereal.COSMIC_INGOT,
                                                null, ItemEthereal.VIBRANIUM_CRYSTAL, null
                                }).register(plugin);
        }
}
