package io.github.nicol.industrialevolution.categories.magic;

import io.github.nicol.industrialevolution.core.LanguageManager;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

/**
 * Chaos Scythe: AOE weapon with chaos wave ability.
 */
public class ChaosScythe extends SlimefunItem {

    private final Random random = new Random();

    public ChaosScythe(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onRightClick);
    }

    private void onRightClick(PlayerRightClickEvent event) {
        Player p = event.getPlayer();

        // Check Cooldown or Charge? For now spam is allowed but dangerous.

        // Chaos Wave Ability
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_SHOOT, 0.5f, 0.5f);
        p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, p.getLocation().add(0, 1, 0), 3);

        int hitCount = 0;
        for (Entity e : p.getNearbyEntities(5, 2, 5)) {
            if (e instanceof LivingEntity && e != p) {
                ((LivingEntity) e).damage(15, p);
                ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
                hitCount++;
            }
        }

        if (hitCount > 0) {
            p.sendMessage(LanguageManager.getInstance().get("tools.chaos-scythe.attack"));
        }

        // Self-Harm Risk (5%)
        if (random.nextDouble() < 0.05) {
            p.damage(10);
            p.sendMessage(LanguageManager.getInstance().get("tools.chaos-scythe.backfire"));
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);
        }
    }
}
