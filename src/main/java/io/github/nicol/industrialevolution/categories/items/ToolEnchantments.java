package io.github.nicol.industrialevolution.categories.items;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

/**
 * Handles custom enchantments/effects for Industrial Evolution tools.
 */
public class ToolEnchantments implements Listener {

    public ToolEnchantments(IndustrialEvolution plugin) {
        // Enchantments initialized
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled())
            return;

        Player p = event.getPlayer();
        ItemStack tool = p.getInventory().getItemInMainHand();

        if (tool == null || tool.getType() == Material.AIR)
            return;

        // Auto-Smelt (Example: works on Iron/Gold ore if holding specific tool or
        // having lore)
        // Check for "Volcanic" or similar in name/lore
        if (hasEnchantment(tool, "Auto-Smelt")) {
            handleAutoSmelt(event);
        }

        // Telekinesis (Items go to inventory)
        if (hasEnchantment(tool, "Telekinesis")) {
            handleTelekinesis(event);
        }
    }

    private boolean hasEnchantment(ItemStack item, String enchName) {
        if (!item.hasItemMeta() || !item.getItemMeta().hasLore()) return false;
        for (String line : item.getItemMeta().getLore()) {
            if (line.contains(enchName)) return true;
        }
        return false;
    }

    private void handleAutoSmelt(BlockBreakEvent event) {
        Block b = event.getBlock();
        Material drop = null;

        if (b.getType() == Material.IRON_ORE || b.getType() == Material.DEEPSLATE_IRON_ORE) {
            drop = Material.IRON_INGOT;
        } else if (b.getType() == Material.GOLD_ORE || b.getType() == Material.DEEPSLATE_GOLD_ORE) {
            drop = Material.GOLD_INGOT;
        } else if (b.getType() == Material.COPPER_ORE || b.getType() == Material.DEEPSLATE_COPPER_ORE) {
            drop = Material.COPPER_INGOT;
        }

        if (drop != null) {
            event.setDropItems(false);
            b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(drop));
            // XP handling if desired
        }
    }

    private void handleTelekinesis(BlockBreakEvent event) {
        event.setDropItems(false);
        Block b = event.getBlock();
        Collection<ItemStack> drops = b.getDrops(event.getPlayer().getInventory().getItemInMainHand());

        for (ItemStack drop : drops) {
            for (ItemStack leftover : event.getPlayer().getInventory().addItem(drop).values()) {
                b.getWorld().dropItemNaturally(b.getLocation(), leftover);
            }
        }
    }
}
