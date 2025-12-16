package io.github.nicol.industrialevolution.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MatterDismantler extends SlimefunItem {

    public MatterDismantler(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onDismantle);
    }

    private void onDismantle(PlayerRightClickEvent event) {
        // Slimefun ItemUseHandler triggers on right click block or air.
        if (event.getClickedBlock().isEmpty())
            return;

        Block b = event.getClickedBlock().get();
        Player p = event.getPlayer();

        if (b.getType() != Material.BEDROCK && b.getType() != Material.BARRIER) {
            b.setType(Material.AIR);
            p.playSound(p.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 1, 2);
            p.giveExp(1); // Reward XP
            // Could add particles custom logic
        }
    }
}
