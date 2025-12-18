package io.github.nicol.industrialevolution.core.multiblocks;

import io.github.nicol.industrialevolution.core.interfaces.EvolutionMachine;
import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public abstract class EvolutionMultiBlock extends EvolutionMachine {

    public EvolutionMultiBlock(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,
            Tier tier) {
        super(itemGroup, item, recipeType, recipe, tier);
    }

    @Nonnull
    public abstract MultiBlockDefinition getStructure();

    // Future: Override tick/processing to enforce structure
}
