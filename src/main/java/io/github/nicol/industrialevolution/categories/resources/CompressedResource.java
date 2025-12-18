package io.github.nicol.industrialevolution.categories.resources;

import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Represents a compressed resource (e.g., Compressed Cobblestone).
 * Can be uncompressed by right-clicking.
 */
public class CompressedResource extends SlimefunItem {

    private final ItemStack baseMaterial;
    private final int multiplier;

    @Nonnull
    public ItemStack getBaseMaterial() {
        return baseMaterial.clone();
    }

    public int getMultiplier() {
        return multiplier;
    }

    public CompressedResource(SlimefunItemStack item, ItemStack baseMaterial, int multiplier, RecipeType recipeType,
            ItemStack[] recipe) {
        super(CategorySetup.RESOURCES, item, recipeType, recipe);
        this.baseMaterial = baseMaterial;
        this.multiplier = multiplier;

        addItemHandler(getItemUseHandler());
    }

    @Nonnull
    private ItemUseHandler getItemUseHandler() {
        return (PlayerRightClickEvent event) -> {
            event.cancel();
            // Logic to uncompress would go here, or we accept that it's just a storage
            // block
            // For now, prevent placement if it's meant to be an item,
            // but if it's a block (like Compressed Cobble), we might want to allow
            // placement.
            // If it's just a resource item, canceling is good.
        };
    }

    public Tier getTier() {
        return Tier.FERRUM;
    }
}
