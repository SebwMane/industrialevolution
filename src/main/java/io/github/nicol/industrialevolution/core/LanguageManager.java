package io.github.nicol.industrialevolution.core;

import io.github.nicol.industrialevolution.IndustrialEvolution;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * Manages internationalization (i18n) for Industrial Evolution.
 * Supports English and Spanish with fallback to English.
 */
public class LanguageManager {

    private static LanguageManager instance;
    private final IndustrialEvolution plugin;
    private final Map<String, FileConfiguration> languages = new HashMap<>();
    private String defaultLanguage = "en";

    public LanguageManager(IndustrialEvolution plugin) {
        this.plugin = plugin;
        instance = this;
        loadLanguages();
    }

    /**
     * Gets the singleton instance.
     */
    public static LanguageManager getInstance() {
        return instance;
    }

    /**
     * Loads all language files from resources.
     */
    private void loadLanguages() {
        // Load default language from config
        if (plugin.getConfig().contains("default-language")) {
            defaultLanguage = plugin.getConfig().getString("default-language", "en");
        }

        // Load English (always required as fallback)
        loadLanguage("en");
        // Load Spanish
        loadLanguage("es");

        plugin.getLogger().info("✓ Languages loaded: en, es (default: " + defaultLanguage + ")");
    }

    /**
     * Loads a specific language file.
     */
    private void loadLanguage(String langCode) {
        // First, save defaults if they don't exist
        File langFolder = new File(plugin.getDataFolder(), "lang");
        if (!langFolder.exists()) {
            langFolder.mkdirs();
        }

        File langFile = new File(langFolder, "messages_" + langCode + ".yml");

        // Save default from resources if file doesn't exist
        if (!langFile.exists()) {
            try {
                plugin.saveResource("lang/messages_" + langCode + ".yml", false);
            } catch (Exception e) {
                plugin.getLogger().log(Level.WARNING, "Could not save language file: " + langCode, e);
            }
        }

        // Load the file
        if (langFile.exists()) {
            languages.put(langCode, YamlConfiguration.loadConfiguration(langFile));
        } else {
            // Try loading from jar as fallback
            InputStream stream = plugin.getResource("lang/messages_" + langCode + ".yml");
            if (stream != null) {
                languages.put(langCode, YamlConfiguration.loadConfiguration(
                        new InputStreamReader(stream, StandardCharsets.UTF_8)));
            }
        }
    }

    /**
     * Gets a localized message in the default language.
     * 
     * @param key  The message key (e.g., "machine.quantum_miner.name")
     * @param args Optional arguments for placeholders {0}, {1}, etc.
     * @return The localized message or the key if not found.
     */
    @Nonnull
    public String get(String key, Object... args) {
        return get(key, defaultLanguage, args);
    }

    /**
     * Gets a localized message in a specific language.
     * 
     * @param key  The message key
     * @param lang The language code (en, es)
     * @param args Optional arguments for placeholders
     * @return The localized message or the key if not found.
     */
    @Nonnull
    public String get(String key, String lang, Object... args) {
        FileConfiguration config = languages.get(lang);

        // Fallback to English if language not found
        if (config == null) {
            config = languages.get("en");
        }

        if (config == null) {
            return key; // No languages loaded
        }

        String message = config.getString(key);

        // Fallback to English if key not found in requested language
        if (message == null && !lang.equals("en")) {
            FileConfiguration enConfig = languages.get("en");
            if (enConfig != null) {
                message = enConfig.getString(key);
            }
        }

        if (message == null) {
            return key; // Key not found anywhere
        }

        // Replace placeholders {0}, {1}, etc.
        for (int i = 0; i < args.length; i++) {
            message = message.replace("{" + i + "}", String.valueOf(args[i]));
        }

        // Translate color codes
        return translateColors(message);
    }

    /**
     * Translates & color codes to Minecraft format.
     */
    private String translateColors(String text) {
        return text.replace("&", "§");
    }

    /**
     * Gets the default language code.
     */
    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    /**
     * Sets the default language.
     */
    public void setDefaultLanguage(String lang) {
        if (languages.containsKey(lang)) {
            this.defaultLanguage = lang;
        }
    }

    /**
     * Reloads all language files.
     */
    public void reload() {
        languages.clear();
        loadLanguages();
    }
}
