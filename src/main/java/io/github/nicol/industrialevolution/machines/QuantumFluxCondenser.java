package io.github.nicol.industrialevolution.machines;

import io.github.nicol.industrialevolution.items.MaterialQuantum;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Quantum Flux Condenser: Generates energy from "entropy" (passively).
 * Acts as a Slimefun generator compatible with energy network.
 */
public class QuantumFluxCondenser extends AGenerator {

    public QuantumFluxCondenser(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
            ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public int getEnergyProduction() {
        return 32;
    }

    @Override
    public int getCapacity() {
        return 512;
    }

    @Override
    protected void registerDefaultFuelTypes() {
        registerFuel(new MachineFuel(3600, MaterialQuantum.QUANTUM_CORE));
        registerFuel(new MachineFuel(600, MaterialQuantum.ENERGIZED_PRISMARINE));
    }

    @Override
    @Nonnull
    public ItemStack getProgressBar() {
        return new ItemStack(Material.DAYLIGHT_DETECTOR);
    }
}
