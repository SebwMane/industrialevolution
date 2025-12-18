package io.github.nicol.industrialevolution.core.interfaces;

import io.github.nicol.industrialevolution.core.AbstractProcessingMachine;
import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Advanced machine base class that incorporates Tier-based logic.
 * All machines in Industrial Evolution should extend this or
 * AbstractProcessingMachine.
 */
public abstract class EvolutionMachine extends AbstractProcessingMachine {

    private final Tier tier;

    protected EvolutionMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,
            Tier tier) {
        super(itemGroup, item, recipeType, recipe);
        this.tier = tier;
    }

    /**
     * Gets the progression tier of this machine.
     * 
     * @return The Tier.
     */
    @Nonnull
    public Tier getTier() {
        return tier;
    }

    @Override
    public int getEnergyConsumption() {
        // Base consumption logic tailored by Tier if not overridden
        // Example: Tier 1 = 20, Tier 2 = 60, Tier 3 = 120...
        int base = super.getEnergyConsumption(); // Default from AContainer/Subclass
        if (base <= 0) {
            return 10 * (1 + tier.getLevel());
        }
        return base;
    }
}
