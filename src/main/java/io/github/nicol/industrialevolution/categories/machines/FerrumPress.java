package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.nicol.industrialevolution.core.interfaces.EvolutionMachine;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class FerrumPress extends EvolutionMachine {

    public static final SlimefunItemStack FERRUM_PRESS = new SlimefunItemStack("IE_FERRUM_PRESS",
            Material.PISTON, "&7Ferrum Press", "", "&7Compresses items with basic hydraulics.", "&eTier 1 Machine");

    public FerrumPress(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, Tier.FERRUM);
    }

    @Nonnull
    @Override
    public String getMachineKey() {
        return "ferrum-press";
    }

    @Override
    public int getEnergyConsumption() {
        return 16; // Low energy
    }

    @Override
    protected void registerDefaultRecipes() {
        // Register Recipes
        if (ResourceItems.COMPRESSED_COBBLESTONE != null) {
            registerRecipe(4, new ItemStack[] { new ItemStack(Material.COBBLESTONE, 9) },
                    new ItemStack[] { ResourceItems.COMPRESSED_COBBLESTONE });
        }
        if (ResourceItems.COMPRESSED_DIRT != null) {
            registerRecipe(4, new ItemStack[] { new ItemStack(Material.DIRT, 9) },
                    new ItemStack[] { ResourceItems.COMPRESSED_DIRT });
        }
        if (ResourceItems.COMPRESSED_GRAVEL != null) {
            registerRecipe(4, new ItemStack[] { new ItemStack(Material.GRAVEL, 9) },
                    new ItemStack[] { ResourceItems.COMPRESSED_GRAVEL });
        }
        if (ResourceItems.COMPRESSED_SAND != null) {
            registerRecipe(4, new ItemStack[] { new ItemStack(Material.SAND, 9) },
                    new ItemStack[] { ResourceItems.COMPRESSED_SAND });
        }
        if (ResourceItems.COMPRESSED_IRON != null) {
            registerRecipe(4, new ItemStack[] { new ItemStack(Material.IRON_INGOT, 9) },
                    new ItemStack[] { ResourceItems.COMPRESSED_IRON });
        }
    }

    public static void setup(io.github.nicol.industrialevolution.IndustrialEvolution plugin) {
        FerrumPress press = new FerrumPress(CategorySetup.MACHINES, FERRUM_PRESS, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        ResourceItems.FERRUM_INGOT, new ItemStack(Material.PISTON), ResourceItems.FERRUM_INGOT,
                        new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.FURNACE),
                        new ItemStack(Material.IRON_BLOCK),
                        ResourceItems.FERRUM_INGOT, new ItemStack(Material.PISTON), ResourceItems.FERRUM_INGOT
                });

        press.register(plugin);
    }
}
