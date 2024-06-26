package dev.boooiil.historia.items.crafted;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import dev.boooiil.historia.items.configuration.crafted.armor.ArmorConfiguration;
import dev.boooiil.historia.items.configuration.crafted.custom.CustomConfiguration;
import dev.boooiil.historia.items.configuration.crafted.tool.ToolConfiguration;
import dev.boooiil.historia.items.configuration.crafted.weapon.WeaponConfiguration;
import dev.boooiil.historia.items.crafted.armor.Armor;
import dev.boooiil.historia.items.crafted.custom.Custom;
import dev.boooiil.historia.items.crafted.modifiers.Weight;
import dev.boooiil.historia.items.crafted.tool.Tool;
import dev.boooiil.historia.items.crafted.weapon.Weapon;

/**
 * <p>
 * The CraftedItemFactory class is a utility class that is used to create
 * instances of crafted items from the Historia plugin. This class provides
 * methods to create instances of Armor, Weapon, Tool, and Custom items from
 * ItemStacks, Configuration objects, and provided values.
 * </p>
 */
public class CraftedItemFactory {

    /** craft item factory default constructor */
    private CraftedItemFactory() {
    }

    /**
     * <p>
     * Create an instance of BaseItem from a given ItemStack. If this ItemStack is
     * not an instance of BaseItem, {@link BaseItem#isValid()} will return false.
     * </p>
     * 
     * This method will NOT generate values for base item, only provide an interface
     * to interact with the base item. If you want to create a new instance of Base
     * Item with provided values, use
     * {@link #createObject(ItemStack, CraftedItemInterface)}.
     * 
     * @param itemStack The ItemStack to be set as the itemStack variable.
     * @param factory   The factory to create the item.
     * @param <T>       The type of the item.
     * @return Instance of {@link BaseItem}
     */
    public static <T extends BaseItem> T createObject(@NotNull ItemStack itemStack,
            CraftedItemInterface<T> factory) {

        return factory.create(itemStack);

    }

    /**
     * <p>
     * Create an instance of Armor from a given ItemStack. If this ItemStack is not
     * an instance of Armor, {@link Armor#isValid()} will return false.
     * </p>
     * 
     * This method will NOT generate values for armor, only provide an interface to
     * interact with the armor. If you want to create a new instance of Armor with
     * provided values, use
     * {@link #createArmor(Material, String, String, double, int, Weight, int, List)}.
     * 
     * @param itemStack The ItemStack to be processed.
     * @return Instance of {@link Armor}
     */
    public static Armor createArmor(@NotNull ItemStack itemStack) {
        return new Armor(itemStack);
    }

    /**
     * <p>
     * Build an instance of Armor from the given parameters. This method is used to
     * create new instances of Armor with provided values.
     * </p>
     * 
     * @param material    The {@link Material} of the armor.
     * @param id          The ID of the armor.
     * @param displayName The display name of the armor (shown to player).
     * @param defense     The defense value of the armor.
     * @param durability  The durability of the armor.
     * @param weight      The {@link Weight} class of the armor.
     * @param weightValue The weight value of the armor.
     * @param lore        The lore of the armor.
     * @return Instance of {@link Armor}
     */
    public static Armor createArmor(Material material, String id, String displayName, double defense, int durability,
            Weight weight, int weightValue, List<String> lore) {
        return new Armor(material, id, displayName, defense, durability, weight, weightValue, lore);
    }

    /**
     * <p>
     * Create an instance of Armor from a given ArmorConfiguration. This will not
     * check if the Armor is valid, as it is assumed that the ArmorConfiguration is
     * valid.
     * </p>
     * 
     * The ArmorConfiguration is used to create a new instance of Armor with
     * provided values. The Armor will have its values populated on instantiation.
     * You can get the item stack of the armor by calling
     * {@link Armor#getItemStack()}.
     * 
     * @param configuration The {@link ArmorConfiguration configuration} of the
     *                      armor.
     * @return Instance of {@link Armor}
     */
    public static Armor createArmor(@NotNull ArmorConfiguration configuration) {

        return new Armor(configuration);

    }

    /**
     * <p>
     * Create an instance of Weapon from a given ItemStack. If this ItemStack is not
     * an instance of Weapon, {@link Weapon#isValid()} will return false.
     * </p>
     * 
     * This method will NOT generate values for weapon, only provide an interface to
     * interact with the weapon. If you want to create a new instance of Weapon with
     * provided values, use
     * {@link #createWeapon(Material, String, String, double, double, double, double, int, Weight, int, List)}.
     * 
     * @param itemStack The ItemStack to be processed.
     * @return Instance of {@link Weapon}
     */
    public static Weapon createWeapon(@NotNull ItemStack itemStack) {
        return new Weapon(itemStack);
    }

    /**
     * <p>
     * Build an instance of Weapon from the given parameters. This method is used to
     * create new instances of Weapon with provided values.
     * </p>
     * 
     * @param material    The {@link Material} of the weapon.
     * @param id          The ID of the weapon.
     * @param displayName The display name of the weapon (shown to player).
     * @param damage      The damage value of the weapon.
     * @param speed       The speed value of the weapon.
     * @param knockback   The knockback value of the weapon.
     * @param sweeping    The sweeping value of the weapon.
     * @param durability  The durability of the weapon.
     * @param weight      The {@link Weight} class of the weapon.
     * @param weightValue The weight value of the weapon.
     * @param lore        The lore of the weapon.
     * @return Instance of {@link Weapon}
     */
    public static Weapon createWeapon(Material material, String id, String displayName, double damage, double speed,
            double knockback, double sweeping,
            int durability, Weight weight, int weightValue, List<String> lore) {
        return new Weapon(material, id, displayName, damage, speed, knockback, sweeping, durability, weight,
                weightValue,
                lore);
    }

    /**
     * <p>
     * Create an instance of Weapon from a given WeaponConfiguration. This will not
     * check if the Weapon is valid, as it is assumed that the WeaponConfiguration
     * is valid.
     * </p>
     * 
     * The WeaponConfiguration is used to create a new instance of Weapon with
     * provided values. The Weapon will have its values populated on instantiation.
     * You can get the item stack of the weapon by calling
     * {@link Weapon#getItemStack()}.
     * 
     * @param configuration The {@link WeaponConfiguration configuration} of the
     *                      weapon.
     * @return Instance of {@link Weapon}
     */
    public static Weapon createWeapon(@NotNull WeaponConfiguration configuration) {

        return new Weapon(configuration);

    }

    /**
     * <p>
     * Create an instance of Tool from a given ItemStack. If this ItemStack is not
     * an instance of Tool, {@link Tool#isValid()} will return false.
     * </p>
     * 
     * This method will NOT generate values for tool, only provide an interface to
     * interact with the tool. If you want to create a new instance of Tool with
     * provided values, use
     * {@link #createTool(Material, String, String, double, double, double, int, Weight, int, List)}.
     * 
     * @param itemStack The ItemStack to be processed.
     * @return Instance of {@link Tool}
     */
    public static Tool createTool(@NotNull ItemStack itemStack) {
        return new Tool(itemStack);
    }

    /**
     * <p>
     * Build an instance of Tool from the given parameters. This method is used to
     * create new instances of Tool with provided values.
     * </p>
     * 
     * @param material    The {@link Material} of the tool.
     * @param id          The ID of the tool.
     * @param displayName The display name of the tool (shown to player).
     * @param damage      The damage value of the tool.
     * @param speed       The speed value of the tool.
     * @param knockback   The knockback value of the tool.
     * @param durability  The durability of the tool.
     * @param weight      The {@link Weight} class of the tool.
     * @param weightValue The weight value of the tool.
     * @param lore        The lore of the tool.
     * @return Instance of{@link Tool}
     */
    public static Tool createTool(Material material, String id, String displayName, double damage, double speed,
            double knockback,
            int durability, Weight weight, int weightValue, List<String> lore) {
        return new Tool(material, id, displayName, damage, speed, knockback, durability, weight, weightValue, lore);
    }

    /**
     * <p>
     * Create an instance of Tool from a given ToolConfiguration. This will not
     * check if the Tool is valid, as it is assumed that the ToolConfiguration is
     * valid.
     * </p>
     * 
     * The ToolConfiguration is used to create a new instance of Tool with provided
     * values. The Tool will have its values populated on instantiation. You can
     * get the item stack of the tool by calling {@link Tool#getItemStack()}.
     * 
     * @param configuration The {@link ToolConfiguration configuration} of the tool.
     * @return Instance of {@link Tool}
     */
    public static Tool createTool(@NotNull ToolConfiguration configuration) {

        return new Tool(configuration);

    }

    /**
     * <p>
     * Create an instance of Custom from a given ItemStack. If this ItemStack is not
     * an instance of Custom, {@link Custom#isValid()} will return false.
     * </p>
     * 
     * This method will NOT generate values for custom, only provide an interface to
     * interact with the custom. If you want to create a new instance of Custom with
     * provided values, use
     * {@link #createCustom(Material, int, String, String, List)}.
     * 
     * @param itemStack
     * @return Instance of {@link Custom}
     */
    public static Custom createCustom(@NotNull ItemStack itemStack) {
        return new Custom(itemStack);
    }

    /**
     * <p>
     * Build an instance of Custom from the given parameters. This method is used to
     * create new instances of Custom with provided values.
     * </p>
     * 
     * @param material    The {@link Material} of the custom.
     * @param amount      The amount of the custom.
     * @param displayName The display name of the custom (shown to player).
     * @param lore        The lore of the custom.
     * @return Instance of {@link Custom}
     */
    public static Custom createCustom(Material material, int amount, String id, String displayName, List<String> lore) {
        return new Custom(material, amount, id, displayName, lore);
    }

    /**
     * <p>
     * Create an instance of Custom from a given CustomItemConfiguration. This will
     * not check if the Custom is valid, as it is assumed that the
     * CustomItemConfiguration is valid.
     * </p>
     * 
     * The CustomItemConfiguration is used to create a new instance of Custom with
     * provided values. The Custom will have its values populated on instantiation.
     * You can get the item stack of the custom by calling
     * {@link Custom#getItemStack()}.
     * 
     * @param configuration The {@link CustomConfiguration configuration} of the
     *                      custom.
     * @return Instance of {@link Custom}
     */
    public static Custom createCustom(@NotNull CustomConfiguration configuration) {
        return new Custom(configuration);
    }
}
