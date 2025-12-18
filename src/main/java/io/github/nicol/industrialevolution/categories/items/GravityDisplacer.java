package io.github.nicol.industrialevolution.categories.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.List;

public class GravityDisplacer extends SlimefunItem {

    public GravityDisplacer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onRightClick);
    }

    private void onRightClick(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        List<Entity> nearby = p.getNearbyEntities(5, 5, 5);

        if (nearby.isEmpty()) {
            p.sendMessage("§7No targets found nearby.");
            return;
        }

        for (Entity e : nearby) {
            if (e instanceof LivingEntity && !e.getUniqueId().equals(p.getUniqueId())) {
                e.setVelocity(new Vector(0, 1.5, 0)); // Launch up
                p.getWorld().playSound(e.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1, 2);
            }
        }

        p.sendMessage("§b*Gravity Displaced*");
    }
}
