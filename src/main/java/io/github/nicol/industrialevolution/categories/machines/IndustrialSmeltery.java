package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.nicol.industrialevolution.core.multiblocks.EvolutionMultiBlock;
import io.github.nicol.industrialevolution.core.multiblocks.MultiBlockDefinition;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class IndustrialSmeltery extends EvolutionMultiBlock {

    public static final SlimefunItemStack INDUSTRIAL_SMELTERY = new SlimefunItemStack("IE_INDUSTRIAL_SMELTERY",
            Material.BLAST_FURNACE, "&6Industrial Smeltery", "", "&7Mass-smelts compressed ores.", "&eTier 2 Machine",
            "&7Requires a 3x3 Smooth Stone base.");

    private final MultiBlockDefinition structure;

    public IndustrialSmeltery() {
        super(CategorySetup.MACHINES, INDUSTRIAL_SMELTERY, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        ResourceItems.COMPRESSED_IRON, new ItemStack(Material.BLAST_FURNACE),
                        ResourceItems.COMPRESSED_IRON,
                        new ItemStack(Material.FURNACE), ResourceItems.FERRUM_INGOT, new ItemStack(Material.FURNACE),
                        ResourceItems.COMPRESSED_IRON, new ItemStack(Material.BLAST_FURNACE),
                        ResourceItems.COMPRESSED_IRON
                }, Tier.INDUSTRIAL);

        // Define 3x3 Smooth Stone platform below
        this.structure = new MultiBlockDefinition();
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                this.structure.add(x, -1, z, Material.SMOOTH_STONE);
            }
        }
    }

    @Nonnull
    @Override
    public String getMachineKey() {
        return "industrial-smeltery";
    }

    @Nonnull
    @Override
    public MultiBlockDefinition getStructure() {
        return structure;
    }

    @Override
    protected void registerDefaultRecipes() {
        // Mass Processing Recipes (Compressed Iron -> 9 Ferrum Ingots)
        // Processing time: 10 seconds?
        registerRecipe(10,
                new ItemStack[] { ResourceItems.COMPRESSED_IRON },
                new ItemStack[] { new SlimefunItemStack(ResourceItems.FERRUM_INGOT, 9) });
    }

    public static void setup(io.github.nicol.industrialevolution.IndustrialEvolution plugin) {
        IndustrialSmeltery smeltery = new IndustrialSmeltery();
        smeltery.register(plugin);
    }
}
