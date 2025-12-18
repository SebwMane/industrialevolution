package io.github.nicol.industrialevolution.core.recipes;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.NamespacedKey;

public class CoreRecipes {

    public static final RecipeType COMPRESSOR_RECIPE = new RecipeType(
            new NamespacedKey(IndustrialEvolution.getInstance(), "singularity_compressor"),
            new io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack(org.bukkit.Material.PISTON,
                    "&bSingularity Compressor"));

    public static final RecipeType EVOLUTION_ALTAR_RECIPE = new RecipeType(
            new NamespacedKey(IndustrialEvolution.getInstance(), "evolution_altar"),
            new io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack(org.bukkit.Material.BEACON,
                    "&eEvolution Altar"));

    // Add more custom recipe types here as we implement machines
    // e.g., MOLECULAR_RECONSTRUCTOR, COSMIC_FORGE, etc.
}
