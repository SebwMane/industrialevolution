package io.github.nicol.industrialevolution.core.interfaces;

import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Base class for Tier 6 (Divine) Items.
 * These items generally have infinite durability or special "ownership"
 * properties.
 */
public abstract class DivineItem extends SlimefunItem {

    public DivineItem(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    public Tier getTier() {
        return Tier.DIVINE;
    }

    /**
     * Defines if this item requires a "Soul Bind" to the player.
     * 
     * @return true by default for Divine items.
     */
    public boolean isSoulBound() {
        return true;
    }
}
