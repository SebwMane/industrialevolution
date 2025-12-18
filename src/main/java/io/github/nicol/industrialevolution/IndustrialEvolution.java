package io.github.nicol.industrialevolution;

import org.bukkit.plugin.java.JavaPlugin;
import javax.annotation.Nonnull;

import io.github.nicol.industrialevolution.core.LanguageManager;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;

/**
 * Industrial Evolution - Main Plugin Class
 * 
 * Un addon visual y dinámico para Slimefun4
 * 
 * @author SebwMane
 * @version 2.1.0
 */
public class IndustrialEvolution extends JavaPlugin implements SlimefunAddon {

    private static IndustrialEvolution instance;
    private LanguageManager languageManager;

    @Override
    public void onEnable() {
        instance = this;

        // Mensaje de inicio
        getLogger().info("========================================");
        getLogger().info("  Industrial Evolution v" + getDescription().getVersion());
        getLogger().info("  Loading Slimefun4 Addon...");
        getLogger().info("========================================");

        // Verificar que Slimefun esté cargado
        if (getServer().getPluginManager().getPlugin("Slimefun") == null) {
            getLogger().severe("ERROR: Slimefun4 not found! Please install Slimefun4 first.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getLogger().info("✓ Slimefun4 detected!");

        // Save default config
        saveDefaultConfig();

        // Initialize Language Manager
        languageManager = new LanguageManager(this);

        // Register Tool Encantments Listener
        getServer().getPluginManager()
                .registerEvents(new io.github.nicol.industrialevolution.categories.items.ToolEnchantments(this), this);

        // Initialize Categories
        io.github.nicol.industrialevolution.setup.CategorySetup.setup(this);

        // Initialize Items & Machines
        io.github.nicol.industrialevolution.categories.resources.ResourceItems.setup(this);
        io.github.nicol.industrialevolution.categories.items.GadgetQuantum.setup(this);
        io.github.nicol.industrialevolution.categories.resources.MaterialSingularity.setup(this);
        io.github.nicol.industrialevolution.categories.items.GadgetSingularity.setup(this);
        io.github.nicol.industrialevolution.categories.magic.ItemEthereal.setup(this);
        io.github.nicol.industrialevolution.categories.magic.ToolEthereal.setup(this);

        io.github.nicol.industrialevolution.categories.machines.MachineRegistry.setup(this);
        io.github.nicol.industrialevolution.categories.machines.MachineSingularity.setup(this);
        io.github.nicol.industrialevolution.categories.machines.MachineEthereal.setup(this);
        io.github.nicol.industrialevolution.categories.energy.SolidFuelGenerator.setup(this);

        getLogger().info("✓ All items and machines registered!");
        getLogger().info("========================================");
        getLogger().info("  Industrial Evolution ENABLED!");
        getLogger().info("  Language: " + languageManager.getDefaultLanguage());
        getLogger().info("========================================");
    }

    @Override
    public void onDisable() {
        getLogger().info("Industrial Evolution DISABLED");
    }

    // ===== SlimefunAddon Implementation =====

    @Override
    @Nonnull
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/SebwMane/IndustrialEvolution/issues";
    }

    // ===== Getters =====

    public static IndustrialEvolution getInstance() {
        return instance;
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }
}
