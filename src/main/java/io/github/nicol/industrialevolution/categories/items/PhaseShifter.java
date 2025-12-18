package io.github.nicol.industrialevolution.categories.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Phase Shifter: Teleports the player forward, phasing through walls.
 */
public class PhaseShifter extends SlimefunItem {

    private static final int COOLDOWN_SECONDS = 10;
    private static final int TELEPORT_DISTANCE = 8;
    private final Map<UUID, Long> cooldowns = new HashMap<>();

    public PhaseShifter(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onRightClick);
    }

    private void onRightClick(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        UUID uuid = p.getUniqueId();

        // Check cooldown
        if (cooldowns.containsKey(uuid)) {
            long remaining = (cooldowns.get(uuid) - System.currentTimeMillis()) / 1000;
            if (remaining > 0) {
                p.sendMessage("§cPhase Shifter on cooldown: " + remaining + "s");
                return;
            }
        }

        // Teleport forward
        Location target = p.getLocation().add(p.getLocation().getDirection().multiply(TELEPORT_DISTANCE));
        p.teleport(target);
        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        p.sendMessage("§b§lPHASE SHIFT!");

        // Set cooldown
        cooldowns.put(uuid, System.currentTimeMillis() + (COOLDOWN_SECONDS * 1000));
    }
}
