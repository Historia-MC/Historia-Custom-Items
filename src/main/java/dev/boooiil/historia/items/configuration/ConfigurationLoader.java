/**
 * The ConfigurationLoader class loads and provides access to various configuration files for the Historia plugin.
 * It contains static methods to retrieve instances of specific configuration classes, such as ArmorConfig,
 * IngotConfig, OreConfig, WeaponConfig, GeneralConfig, CustomItemConfig, and CropConfig. It also provides
 * methods to initialize and reload the configuration files.
 * The configuration files are loaded from the plugin's resources folder and are in YAML format.
 * 
 * @see ArmorConfig
 * @see IngotConfig
 * @see OreConfig
 * @see WeaponConfig
 * @see GeneralConfig
 * @see CustomItemConfig
 * @see CropConfig
 */
package dev.boooiil.historia.items.configuration;

import dev.boooiil.historia.items.configuration.specific.*;

/**
 * It loads the configuration files.
 */
public class ConfigurationLoader {

    private static final ArmorConfig armorConfig = new ArmorConfig();
    private static final WeaponConfig weaponConfig = new WeaponConfig();
    private static final GeneralConfig generalConfig = new GeneralConfig();
    private static final CustomItemConfig customItemConfig = new CustomItemConfig();
    private static final ToolConfig toolConfig = new ToolConfig();

    /**
     * It returns the armorConfig variable
     * 
     * @return The armorConfig variable.
     */
    public static ArmorConfig getArmorConfig() {
        return armorConfig;
    }

    /**
     * It returns the weaponConfig variable
     * 
     * @return The weaponConfig object.
     */
    public static WeaponConfig getWeaponConfig() {
        return weaponConfig;
    }

    /**
     * This function returns the generalConfig object
     * 
     * @return The generalConfig object.
     */
    public static GeneralConfig getGeneralConfig() {
        return generalConfig;
    }

    /**
     * It returns the customItemConfig variable
     * 
     * @return The customItemConfig variable.
     */
    public static CustomItemConfig getCustomItemConfig() {
        return customItemConfig;
    }

    public static ToolConfig getToolConfig() {

        return toolConfig;
    }

    /**
     * It loads the configuration files
     */
    public static void init() {

        armorConfig.loadConfiguration("armor.yml");
        weaponConfig.loadConfiguration("weapons.yml");
        customItemConfig.loadConfiguration("items.yml");
        toolConfig.loadConfiguration("tools.yml");

    }

    /**
     * It's a function that reloads the config file
     */
    public static void reload() {

        init();

    }

}
