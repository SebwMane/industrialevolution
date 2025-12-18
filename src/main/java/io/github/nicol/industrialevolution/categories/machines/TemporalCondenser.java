package io.github.nicol.industrialevolution.categories.machines;

import io.github.nicol.industrialevolution.categories.resources.MaterialSingularity;
import io.github.nicol.industrialevolution.categories.resources.ResourceItems;
import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.nicol.industrialevolution.core.interfaces.EvolutionMachine;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class TemporalCondenser extends EvolutionMachine {

    public static final SlimefunItemStack TEMPORAL_CONDENSER = new SlimefunItemStack("IE_TEMPORAL_CONDENSER",
            Material.BEACON, "&dTemporal Condenser", "", "&7Condenses time into crystal.",
            "&7Process takes 7 real-time days.", "&5Singularity Machine");

    public TemporalCondenser() {
        super(CategorySetup.MACHINES, TEMPORAL_CONDENSER, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        MaterialSingularity.UNSTABLE_SINGULARITY, ResourceItems.QUANTUM_CORE,
                        MaterialSingularity.UNSTABLE_SINGULARITY,
                        ResourceItems.QUANTUM_CORE, new ItemStack(Material.CLOCK), ResourceItems.QUANTUM_CORE,
                        MaterialSingularity.UNSTABLE_SINGULARITY, ResourceItems.QUANTUM_CORE,
                        MaterialSingularity.UNSTABLE_SINGULARITY
                }, Tier.SINGULARITY);
    }

    @Nonnull
    @Override
    public String getMachineKey() {
        return "temporal-condenser";
    }

    @Override
    public int getEnergyConsumption() {
        return 1024; // High continuous power for 7 days
    }

    @Nonnull
    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.CLOCK);
    }

    @Override
    protected void registerDefaultRecipes() {
        // 7 days = 604800 seconds
        registerRecipe(604800,
                new ItemStack[] { MaterialSingularity.UNSTABLE_SINGULARITY },
                new ItemStack[] { ResourceItems.TIME_CRYSTAL });
    }

    public static void setup(io.github.nicol.industrialevolution.IndustrialEvolution plugin) {
        new TemporalCondenser().register(plugin);
    }
}
