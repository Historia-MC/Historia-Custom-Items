package dev.boooiil.historia.items.crafted;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

interface CraftedItemInterface<T> {
    T create(@NotNull ItemStack itemStack);
}