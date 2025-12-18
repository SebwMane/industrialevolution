package io.github.nicol.industrialevolution.setup;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.nicol.industrialevolution.IndustrialEvolution;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

/**
 * Defines the categories (ItemGroups) for Industrial Evolution.
 * These appear as separate tabs in the Slimefun Guide.
 */
public class CategorySetup {

        public static ItemGroup RESOURCES;
        public static ItemGroup MINERALS;
        public static ItemGroup ITEMS;
        public static ItemGroup MACHINES;
        public static ItemGroup ENERGY;
        public static ItemGroup STORAGE;
        public static ItemGroup NETWORK;
        public static ItemGroup MAGIC;

        public static void setup(IndustrialEvolution plugin) {
                // 1. Resources / Recursos
                RESOURCES = new ItemGroup(
                                new NamespacedKey(plugin, "ie_resources"),
                                new CustomItemStack(Material.IRON_INGOT, "&b&lRecursos", "",
                                                "&7Materiales base, aleaciones", "&7y componentes comprimidos."));
                RESOURCES.register(plugin);

                // 2. Minerals / Minerales
                MINERALS = new ItemGroup(
                                new NamespacedKey(plugin, "ie_minerals"),
                                new CustomItemStack(Material.DIAMOND_ORE, "&a&lMinerales", "",
                                                "&7Nuevos minerales y cristales", "&7encontrados en el mundo."));
                MINERALS.register(plugin);

                // 3. Items / Objetos
                ITEMS = new ItemGroup(
                                new NamespacedKey(plugin, "ie_items"),
                                new CustomItemStack(Material.SLIME_BALL, "&e&lObjetos", "",
                                                "&7Componentes intermedios", "&7y herramientas varias."));
                ITEMS.register(plugin);

                // 4. Machines / Maquinas
                MACHINES = new ItemGroup(
                                new NamespacedKey(plugin, "ie_machines"),
                                new CustomItemStack(Material.BLAST_FURNACE, "&c&lMaquinas", "",
                                                "&7Procesadores avanzados y", "&7fábricas automáticas."));
                MACHINES.register(plugin);

                // 5. Energy / Electricidad
                ENERGY = new ItemGroup(
                                new NamespacedKey(plugin, "ie_energy"),
                                new CustomItemStack(Material.REDSTONE_BLOCK, "&e&lElectricidad", "",
                                                "&7Generadores, capacitores", "&7y reactores de vacío."));
                ENERGY.register(plugin);

                // 6. Storage / Inventario
                STORAGE = new ItemGroup(
                                new NamespacedKey(plugin, "ie_storage"),
                                new CustomItemStack(Material.CHEST, "&6&lAlmacenamiento", "",
                                                "&7Mochilas, discos y", "&7sistemas de stock."));
                STORAGE.register(plugin);

                // 7. Network / Redes
                NETWORK = new ItemGroup(
                                new NamespacedKey(plugin, "ie_network"),
                                new CustomItemStack(Material.ENDER_PEARL, "&9&lNetwork", "",
                                                "&7Transporte de items y", "&7energía inalámbrica."));
                NETWORK.register(plugin);

                // 8. Magic / Magia (Divine)
                MAGIC = new ItemGroup(
                                new NamespacedKey(plugin, "ie_magic"),
                                new CustomItemStack(Material.ENCHANTING_TABLE, "&d&lMagia Divina", "",
                                                "&7El camino hacia la", "&7ascensión y divinidad."));
                MAGIC.register(plugin);

                plugin.getLogger().info("✓ Categorias actualizadas: Recursos, Minerales, Maquinas, etc.");
        }
}
