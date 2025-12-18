package io.github.nicol.industrialevolution.categories.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import io.github.nicol.industrialevolution.IndustrialEvolution;

public class BlackHoleGrenade extends SlimefunItem {

    public BlackHoleGrenade(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onThrow);
    }

    private void onThrow(PlayerRightClickEvent event) {
        Player p = event.getPlayer();
        event.cancel(); // Don't throw vanilla ender pearl

        // Consume item
        if (p.getGameMode() != org.bukkit.GameMode.CREATIVE) {
            event.getItem().setAmount(event.getItem().getAmount() - 1);
        }

        EnderPearl pearl = p.launchProjectile(EnderPearl.class);
        pearl.setVelocity(p.getLocation().getDirection().multiply(1.5));

        // Task to simulate black hole when it lands or ticks
        new BukkitRunnable() {
            @Override
            public void run() {
                if (pearl.isDead() || pearl.isOnGround()) {
                    triggerBlackHole(pearl.getLocation());
                    pearl.remove();
                    this.cancel();
                }
            }
        }.runTaskTimer(IndustrialEvolution.getInstance(), 1L, 1L);
    }

    private void triggerBlackHole(Location loc) {
        loc.getWorld().playSound(loc, Sound.ENTITY_ENDERMAN_DEATH, 1, 0.5f);
        loc.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 1);

        // Pull entities
        for (Entity e : loc.getWorld().getNearbyEntities(loc, 10, 10, 10)) {
            if (e instanceof LivingEntity && !(e instanceof Player)) {
                Vector direction = loc.toVector().subtract(e.getLocation().toVector()).normalize().multiply(0.5);
                e.setVelocity(direction);
                ((LivingEntity) e).damage(10); // Void damage
            }
        }
    }
}
