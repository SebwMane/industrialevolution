package io.github.nicol.industrialevolution.categories.magic;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import java.util.List;

/**
 * Vibranium Drill: High-tier mining tool.
 * Implements 3x3 mining functionality.
 */
public class VibraniumDrill extends SlimefunItem {

    public VibraniumDrill(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler(new BlockBreakHandler(false, false) {
            @Override
            public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                if (e.getPlayer().isSneaking())
                    return; // Shift to mine single block

                Block b = e.getBlock();
                // Simple 3x3 mines around the block
                BlockFace face = getTargetBlockFace(e.getPlayer());
                if (face == null)
                    return;

                int xMod = 1, yMod = 1, zMod = 1;
                if (Math.abs(face.getModX()) > 0) {
                    xMod = 0;
                } // Flat on X
                else if (Math.abs(face.getModY()) > 0) {
                    yMod = 0;
                } // Flat on Y
                else if (Math.abs(face.getModZ()) > 0) {
                    zMod = 0;
                } // Flat on Z

                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        for (int z = -1; z <= 1; z++) {
                            if (x == 0 && y == 0 && z == 0)
                                continue;
                            if (xMod == 0 && x != 0)
                                continue;
                            if (yMod == 0 && y != 0)
                                continue;
                            if (zMod == 0 && z != 0)
                                continue;

                            Block target = b.getRelative(x, y, z);
                            if (target.getType() == Material.BEDROCK || target.getType() == Material.BARRIER)
                                continue;
                            if (BlockStorage.check(target) != null)
                                continue; // Safety

                            target.breakNaturally(item);
                        }
                    }
                }
            }
        });
    }

    private BlockFace getTargetBlockFace(org.bukkit.entity.Player player) {
        List<Block> lastTwoTargetBlocks = player.getLastTwoTargetBlocks(null, 100);
        if (lastTwoTargetBlocks.size() != 2 || !lastTwoTargetBlocks.get(1).getType().isOccluding())
            return null;
        Block target = lastTwoTargetBlocks.get(1);
        Block adjacent = lastTwoTargetBlocks.get(0);
        return target.getFace(adjacent);
    }
}
