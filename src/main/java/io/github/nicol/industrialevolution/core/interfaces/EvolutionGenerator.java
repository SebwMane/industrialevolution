package io.github.nicol.industrialevolution.core.interfaces;

import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public abstract class EvolutionGenerator extends SlimefunItem implements EnergyNetProvider {

    private final Tier tier;

    public EvolutionGenerator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,
            Tier tier) {
        super(itemGroup, item, recipeType, recipe);
        this.tier = tier;
    }

    @Nonnull
    public Tier getTier() {
        return tier;
    }
}
