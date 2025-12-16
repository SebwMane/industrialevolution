package io.github.tuusuario.industrialevolution;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;

public class IndustrialEvolution extends JavaPlugin implements SlimefunAddon {

    private static IndustrialEvolution instance;

    @Override
    public void onEnable() {
        instance = this;

        // Registrar categorías, items, listeners, etc.
        getLogger().info("Industrial Evolution has been enabled!");
    }

    @Override
    public void onDisable() {
        instance = null;
        getLogger().info("Industrial Evolution has been disabled!");
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/sebwmane/IndustrialEvolution/issues";
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public static IndustrialEvolution getInstance() {
        return instance;
    }
}
