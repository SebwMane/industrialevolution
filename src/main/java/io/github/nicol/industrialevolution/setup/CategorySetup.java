package io.github.nicol.industrialevolution.setup;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.nicol.industrialevolution.IndustrialEvolution;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

/**
 * Defines the categories (ItemGroups) for Industrial Evolution.
 * These appear as separate tabs in the Slimefun Guide.
 */
public class CategorySetup {

        public static ItemGroup QUANTUM_ERA;
        public static ItemGroup SINGULARITY_ERA;
        public static ItemGroup INFINITY_ERA;

        public static void setup(IndustrialEvolution plugin) {
                // Tier 6: Quantum Era
                QUANTUM_ERA = new ItemGroup(
                                new NamespacedKey(plugin, "ie_quantum_era"),
                                new CustomItemStack(Material.NETHERITE_BLOCK, "&b&lQuantum Era", "",
                                                "&7Tier 6 - Industrial Evolution", "&7Advanced quantum technology."));
                QUANTUM_ERA.register(plugin); // <-- CRITICAL: Register the ItemGroup!

                // Tier 7: Singularity Era
                SINGULARITY_ERA = new ItemGroup(
                                new NamespacedKey(plugin, "ie_singularity_era"),
                                new CustomItemStack(Material.BEACON, "&5&lSingularity Era", "",
                                                "&7Tier 7 - Industrial Evolution", "&7Harness black hole power."));
                SINGULARITY_ERA.register(plugin); // <-- CRITICAL: Register the ItemGroup!

                // Tier 8: Ethereal Ascension
                INFINITY_ERA = new ItemGroup(
                                new NamespacedKey(plugin, "ie_infinity_era"),
                                new CustomItemStack(Material.END_CRYSTAL, "&d&lEthereal Ascension", "",
                                                "&7Tier 8 - Industrial Evolution", "&7Transcend reality."));
                INFINITY_ERA.register(plugin); // <-- CRITICAL: Register the ItemGroup!

                plugin.getLogger().info("✓ Categories registered!");
        }
}
