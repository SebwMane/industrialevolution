package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.nicol.industrialevolution.core.multiblocks.EvolutionMultiBlock;
import io.github.nicol.industrialevolution.core.multiblocks.MultiBlockDefinition;

import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class EvolutionAltar extends EvolutionMultiBlock {

    public static final SlimefunItemStack EVOLUTION_ALTAR = new SlimefunItemStack("IE_EVOLUTION_ALTAR",
            Material.ENCHANTING_TABLE, "&eEvolution Altar", "", "&7Performs Divine Sacrifices.",
            "&eTier 6 Multi-block", "&7Requires 5x5 Gold/Quartz structure.");

    private final MultiBlockDefinition structure;

    public EvolutionAltar() {
        super(CategorySetup.MACHINES, EVOLUTION_ALTAR, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.BEACON),
                        new ItemStack(Material.GOLD_BLOCK),
                        new ItemStack(Material.DIAMOND_BLOCK), new ItemStack(Material.ENCHANTING_TABLE),
                        new ItemStack(Material.DIAMOND_BLOCK),
                        new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.BEACON),
                        new ItemStack(Material.GOLD_BLOCK)
                }, Tier.DIVINE);

        this.structure = new MultiBlockDefinition();
        // Simple 5x5 base of Gold Blocks
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                this.structure.add(x, -1, z, Material.GOLD_BLOCK);
            }
        }
    }

    @Nonnull
    @Override
    public String getMachineKey() {
        return "evolution-altar";
    }

    @Nonnull
    @Override
    public MultiBlockDefinition getStructure() {
        return structure;
    }

    @Override
    public int getEnergyConsumption() {
        return 1024; // High energy cost for divine magic
    }

    public static void setup(io.github.nicol.industrialevolution.IndustrialEvolution plugin) {
        new EvolutionAltar().register(plugin);
    }
}
