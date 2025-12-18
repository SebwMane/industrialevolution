package io.github.nicol.industrialevolution.core.multiblocks;

import org.bukkit.Material;
import org.bukkit.block.Block;

import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class MultiBlockDefinition {

    private final Map<Vector, Material> structure = new HashMap<>();

    public MultiBlockDefinition() {
    }

    public MultiBlockDefinition add(int x, int y, int z, Material material) {
        structure.put(new Vector(x, y, z), material);
        return this;
    }

    public boolean check(Block centerBlock) {
        for (Map.Entry<Vector, Material> entry : structure.entrySet()) {
            Vector offset = entry.getKey();
            Block relative = centerBlock.getRelative(offset.getBlockX(), offset.getBlockY(), offset.getBlockZ());

            if (relative.getType() != entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
