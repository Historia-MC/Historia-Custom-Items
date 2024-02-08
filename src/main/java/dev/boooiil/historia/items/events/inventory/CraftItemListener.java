package dev.boooiil.historia.items.events.inventory;

import dev.boooiil.historia.core.classes.user.HistoriaPlayer;
import dev.boooiil.historia.core.database.internal.PlayerStorage;
import dev.boooiil.historia.items.configuration.ConfigurationLoader;
import dev.boooiil.historia.items.configuration.specific.ArmorConfigurationLoader;
import dev.boooiil.historia.items.configuration.specific.CustomItemConfig;
import dev.boooiil.historia.items.configuration.specific.WeaponConfig;
import dev.boooiil.historia.items.handlers.inventory.CraftingResult;
import dev.boooiil.historia.items.util.Logging;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftItemListener implements Listener {

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {

        System.out.println("CraftItemEvent triggered");

        HistoriaPlayer historiaPlayer = PlayerStorage.getPlayer(event.getWhoClicked().getUniqueId(), false);
        WeaponConfig weaponConfig = ConfigurationLoader.getWeaponConfig();
        ArmorConfigurationLoader armorConfig = ConfigurationLoader.getArmorConfig();
        CustomItemConfig customItemConfig = ConfigurationLoader.getCustomItemConfig();
        CraftingResult craftingResult;

        ItemStack item = event.getClickedInventory().getItem(0);

        Logging.debugToConsole("[onCraftResult] Crafting a " + item.getItemMeta().getLocalizedName());

        if (weaponConfig.isValid(item.getItemMeta().getLocalizedName())) {

            Logging.debugToConsole("[onCraftResult] Crafting a weapon");

            craftingResult = new CraftingResult(
                    event.getInventory(),
                    item,
                    weaponConfig.getObject(item.getItemMeta().getLocalizedName()),
                    historiaPlayer);

        } else if (armorConfig.isValid(item.getItemMeta().getLocalizedName())) {

            Logging.debugToConsole("[onCraftResult] Crafting an armor");

            craftingResult = new CraftingResult(
                    event.getInventory(),
                    item,
                    armorConfig.getObject(item.getItemMeta().getLocalizedName()),
                    historiaPlayer);

        } else {

            Logging.debugToConsole("[onCraftResult] Crafting a custom item");

            craftingResult = new CraftingResult(
                    event.getInventory(),
                    item,
                    customItemConfig.getObject(item.getItemMeta().getLocalizedName()),
                    historiaPlayer);

        }

        if (craftingResult != null) {

            if (!craftingResult.getCraftedItem().canCraft(historiaPlayer.getProficiency().getName()))
                event.setCancelled(true);
            else
                craftingResult.generateRandomModifiers();

        }
    }

}
