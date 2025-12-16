package io.github.nicol.industrialevolution.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Staff of Time: Accelerates machine ticks.
 */
public class StaffOfTime extends SlimefunItem {

    public StaffOfTime(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onRightClick);
    }

    private void onRightClick(PlayerRightClickEvent event) {
        if (event.getClickedBlock().isEmpty())
            return;
        Block b = event.getClickedBlock().get();
        Player p = event.getPlayer();

        SlimefunItem sfItem = BlockStorage.check(b);
        if (sfItem != null) {
            // Simulate "Time Warp" effect
            p.getWorld().spawnParticle(Particle.PORTAL, b.getLocation().add(0.5, 0.5, 0.5), 20);
            p.getWorld().playSound(b.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 1, 2);
            p.sendMessage("§e§lTIME WARP! §7Machine accelerated.");
        }
    }
}
