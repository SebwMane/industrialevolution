package io.github.nicol.industrialevolution.categories.energy;

import io.github.nicol.industrialevolution.core.definitions.Tier;
import io.github.nicol.industrialevolution.core.interfaces.EvolutionGenerator;
import io.github.nicol.industrialevolution.setup.CategorySetup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class SolidFuelGenerator extends EvolutionGenerator {

    public static final SlimefunItemStack SOLID_FUEL_GENERATOR = new SlimefunItemStack("IE_SOLID_FUEL_GENERATOR",
            Material.FURNACE, "&eSolid Fuel Generator", "", "&7Burns coal and wood for power.", "&eTier 1 Generator",
            "&eRate: 16 J/t");

    public SolidFuelGenerator() {
        super(CategorySetup.ENERGY, SOLID_FUEL_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.COBBLESTONE), new ItemStack(Material.GLASS),
                        new ItemStack(Material.COBBLESTONE),
                        new ItemStack(Material.COBBLESTONE), new ItemStack(Material.FURNACE),
                        new ItemStack(Material.COBBLESTONE),
                        new ItemStack(Material.COBBLESTONE), new ItemStack(Material.REDSTONE),
                        new ItemStack(Material.COBBLESTONE)
                }, Tier.FERRUM);
    }

    @Override
    @SuppressWarnings("deprecation")
    public int getGeneratedOutput(@Nonnull Location l, @Nonnull Config data) {
        // Simplified Logic: If furnace burn time > 0, return 16.
        // Needs BlockTicker or similar to actually consume fuel.
        // For now, implementing as a placeholder standard generator hook.
        // The detailed fuel consumption logic requires a BlockTicker.
        return 16;
    }

    @Override
    public int getCapacity() {
        return 512;
    }

    // Needs to implement RegisterBlockHandler or similar to handle click/GUI for
    // fuel input.
    // However, Slimefun's AContainer is what usually handles the GUI/Tick.
    // Creating a proper generator from scratch is complex.
    // For this step, we register it as a concept item.

    public static void setup(io.github.nicol.industrialevolution.IndustrialEvolution plugin) {
        new SolidFuelGenerator().register(plugin);
    }
}
