package dev.boooiil.historia.items.handlers.inventory.prepareCraftItem;

import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class PrepareItemCraftHandler {

    PrepareItemCraftEvent event;
    CraftingInventory craftingInventory;

    public PrepareItemCraftHandler(PrepareItemCraftEvent event) {
        this.event = event;
        this.craftingInventory = event.getInventory();

    }

    public void parseInventoryAndGiveResult() {

        ItemStack item = parseInventory();

        if (item == null)
            event.getInventory().setResult(event.getRecipe().getResult());
        else
            event.getInventory().setResult(item);

    }

    private ItemStack parseInventory() {

        PrepareItemCraftInventoryHelper helper = new PrepareItemCraftInventoryHelper(craftingInventory.getMatrix());
        PrepareItemCraftItemHelper itemHelper = new PrepareItemCraftItemHelper(helper);

        itemHelper.doMatch();

        return itemHelper.getResult();

    }

}