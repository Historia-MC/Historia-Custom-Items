package dev.boooiil.historia.items.items.getter;

import dev.boooiil.historia.items.configuration.ConfigurationLoader;
import dev.boooiil.historia.items.items.craftable.Armor;
import dev.boooiil.historia.items.items.craftable.CustomItem;
import dev.boooiil.historia.items.items.craftable.Tool;
import dev.boooiil.historia.items.items.craftable.Weapon;

public class ItemGetter {

    /**
     * Get an armor object from the armor config.
     * 
     * @param localizedName The localizedName of the armor.
     * @return The armor object.
     */
    public static Armor getArmor(String localizedName) {

        return ConfigurationLoader.getArmorConfig().getObject(localizedName);

    }

    /**
     * Get a custom item object from the custom item config.
     * 
     * @param localizedName The localizedName of the custom item.
     * @return The custom item object.
     */
    public static CustomItem getCustomItem(String localizedName) {

        return ConfigurationLoader.getCustomItemConfig().getObject(localizedName);

    }

    /**
     * Get a weapon object from the weapon config.
     * 
     * @param localizedName The localizedName of the weapon.
     * @return The weapon object.
     */
    public static Weapon getWeapon(String localizedName) {

        return ConfigurationLoader.getWeaponConfig().getObject(localizedName);

    }

    /**
     * Get a tool object from the tool config.
     * 
     * @param localizedName The localizedName of the tool.
     * @return The tool object.
     */
    public static Tool getTool(String localizedName) {

        return ConfigurationLoader.getToolConfig().getObject(localizedName);

    }

}