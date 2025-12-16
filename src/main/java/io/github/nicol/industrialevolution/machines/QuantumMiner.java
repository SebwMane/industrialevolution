package io.github.nicol.industrialevolution.machines;

import io.github.nicol.industrialevolution.core.AbstractProcessingMachine;
import io.github.nicol.industrialevolution.core.LanguageManager;
import io.github.nicol.industrialevolution.items.MaterialQuantum;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Quantum-Assisted Deep Miner: Generates ores from the "void" based on fuel
 * quality.
 */
public class QuantumMiner extends AbstractProcessingMachine {

    private final Random random = new Random();

    public QuantumMiner(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public String getMachineKey() {
        return "quantum-miner";
    }

    @Override
    public int getEnergyConsumption() {
        return 128;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getCapacity() {
        return 2048;
    }

    @Override
    protected void registerDefaultRecipes() {
        // Register standard recipes as "fuel" definitions
        // These are just visual for the guide, the logic is custom in tick() if we
        // override it,
        // but AContainer uses standard recipes for processing.
        // We will map Fuels -> Outputs with chances.
        // Since AContainer forces 1 Input -> 1 Output (or 2), we simulate the rarity by
        // registering MULTIPLE recipes for the same input but with different outputs?
        // No, AContainer takes the first match.
        // So we must override the processing logic OR register 1 recipe that outputs a
        // "Geode" that opens?
        // OR: We define 1 recipe per fuel that outputs a generic "Mining Result" but we
        // intercept the output.

        // Actually, let's keep it simple for now and use the standard recipe system but
        // with the specific fuels.
        // We will define specific "guaranteed" recipes for the fuel items to ensure
        // they are processed.

        // Common Tier (Coal Block)
        registerRecipe(10, new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.IRON_ORE, 4));
        registerRecipe(10, new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.COPPER_ORE, 8));
        registerRecipe(10, new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.COAL, 12));

        // Uncommon Tier (Dense Carbon)
        registerRecipe(15, MaterialQuantum.DENSE_CARBON_ALLOY, new ItemStack(Material.GOLD_ORE, 4));
        registerRecipe(15, MaterialQuantum.DENSE_CARBON_ALLOY, new ItemStack(Material.LAPIS_ORE, 8));
        registerRecipe(15, MaterialQuantum.DENSE_CARBON_ALLOY, new ItemStack(Material.REDSTONE, 12));

        // Rare Tier (Energized Prismarine) - Only use ONE recipe per input to avoid
        // conflicts if AContainer stops at first match.
        // AContainer DOES stop at first match usually.
        // So randomize outputs, we need to override the findNextRecipe method or
        // similar.
        // But findNextRecipe is internal.

        // Alternative: We create a custom processing method.
        // But simpler for this phase:
        // We register ONE recipe per fuel type that produces a balanced output of that
        // tier.

        // Common: Coal Block -> 4 Iron + 4 Coal
        registerRecipe(20, new ItemStack[] { new ItemStack(Material.COAL_BLOCK) },
                new ItemStack[] { new ItemStack(Material.IRON_ORE, 4), new ItemStack(Material.COAL, 4) });

        // Uncommon: Dense Carbon -> 4 Gold + 8 Redstone
        registerRecipe(30, new ItemStack[] { MaterialQuantum.DENSE_CARBON_ALLOY },
                new ItemStack[] { new ItemStack(Material.GOLD_ORE, 4), new ItemStack(Material.REDSTONE, 8) });

        // Rare: Energized Prismarine -> 2 Diamond + 4 Emerald
        registerRecipe(40, new ItemStack[] { MaterialQuantum.ENERGIZED_PRISMARINE },
                new ItemStack[] { new ItemStack(Material.DIAMOND, 2), new ItemStack(Material.EMERALD, 4) });

        // Legendary: Quantum Core -> 2 Ancient Debris + 1 Netherite Scrap
        registerRecipe(60, new ItemStack[] { MaterialQuantum.QUANTUM_CORE },
                new ItemStack[] { new ItemStack(Material.ANCIENT_DEBRIS, 2),
                        new ItemStack(Material.NETHERITE_SCRAP, 1) });
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.NETHERITE_PICKAXE);
    }
}
