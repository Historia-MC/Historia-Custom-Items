package dev.boooiil.historia.items.configuration.specific;

import dev.boooiil.historia.items.configuration.BaseConfiguration;
import dev.boooiil.historia.items.items.craftable.CraftedItem;
import dev.boooiil.historia.items.items.craftable.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * It's a class that gets information from a configuration file.
 */
public class ToolConfig extends BaseConfiguration<Tool> {

    /**
     * Used to create a new instance of Tool.
     * 
     * @param toolName - Name of the tool to create.
     * @return Returns a Tool object.
     */
    public Tool createNew(String toolName) {

        return new Tool(toolName);

    }

    /**
     * It takes a list of items and a list of shapes, and returns a tool if the
     * items and shapes
     * match a tool recipe
     * 
     * @param inputItems A list of strings that represent the items used to craft
     *                   the tool.
     * @param inputShape A list of strings that represent the shape of the tool.
     * @return A Tool object.
     */
    public Tool getObject(List<String> inputItems, List<String> inputShape) {

        Tool tool = null;

        for (Map.Entry<String, Tool> entry : map.entrySet()) {

            boolean armorValid = entry.getValue().isValidRecipe(inputItems, inputShape);

            if (armorValid) {
                tool = entry.getValue();
                break;
            }

        }

        return tool;

    }

    /**
     * If the tool name is valid, return the tool object from the map. Otherwise,
     * return null
     * 
     * @param toolName The name of the tool you want to get.
     * @return A Tool object.
     */
    public Tool getObject(String toolName) {

        if (isValid(toolName))
            return map.get(toolName);
        else
            return null;

    }

    /**
     * It checks if the shape of the recipe is valid
     * 
     * @param shape The shape of the recipe.
     * @return A boolean value.
     */
    public boolean validShape(List<String> shape) {

        boolean found = false;

        for (Tool tool : map.values()) {

            if (tool.getRecipeShape().equals(shape)) {

                found = true;
                break;

            }
        }

        return found;

    }

    /**
     * It returns a list of all the recipes for the tools
     * 
     * @return A list of lists of strings.
     */
    public List<List<String>> getAllShapes() {

        List<List<String>> set = new ArrayList<>();

        for (Tool tool : map.values()) {

            set.add(tool.getRecipeShape());
        }

        return set;

    }

    /**
     * It returns a list of all the items that have the same recipe shape as the one
     * passed in
     * 
     * @param shape A list of strings that represent the shape of the recipe.
     * @return A list of all the tool items that match the shape.
     */
    public List<CraftedItem> getAllMatchingShape(List<String> shape) {

        List<CraftedItem> set = new ArrayList<>();

        for (Tool tool : map.values()) {

            if (tool.getRecipeShape().equals(shape)) {

                set.add(tool);

            }
        }

        return set;

    }
}