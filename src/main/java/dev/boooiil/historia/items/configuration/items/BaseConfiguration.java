package dev.boooiil.historia.items.configuration.items;

import dev.boooiil.historia.items.util.Logging;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class BaseConfiguration {

    protected List<String> recipeShape;
    protected List<String> recipeItems;
    protected List<String> proficiencies;
    protected boolean isShaped;

    protected ItemStack itemStack;

    /**
     * This function returns the list of items that are required to craft the item
     *
     * @return The list of recipe items.
     */
    public List<String> getRecipeItems() {

        return this.recipeItems;

    }

    /**
     * It returns the recipe shape
     *
     * @return The recipe shape.
     */
    public List<String> getRecipeShape() {

        return this.recipeShape;

    }

    /**
     * Validate recipe of items to see if it matches an armor.
     * 
     * @param inputItems List of recipe items.
     * @param inputShape Recipe shape.
     *
     * @return If the recipe is valid.
     */
    public Boolean isValidRecipe(List<String> inputItems, List<String> inputShape) {

        boolean validItems = this.recipeItems.equals(inputItems);
        boolean validShape = this.recipeShape.equals(inputShape);

        return validItems && validShape;

    }

    /**
     * It returns if the item is shape dependent.
     *
     * @return If the item is shape dependent.
     */
    public boolean isShapeDependent() {
        return isShaped;
    }

    /**
     * It returns whether the given proficiency can craft this item.
     * 
     * @param proficiency The proficiency to check.
     * @return If the proficiency can craft the item.
     */
    public boolean canCraft(String proficiency) {

        Logging.debugToConsole("[CraftedItem] Proficiencies: " + this.proficiencies.toString());

        if (this.proficiencies.contains("ALL"))
            return true;
        else
            return this.proficiencies.contains(proficiency);

    }

    /**
     * It returns the item stack of the item.
     *
     * @return The item stack.
     */
    public ItemStack getItemStack() {
        return itemStack;
    }
}