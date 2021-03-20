package de.apis.itemcreator;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ReturnHat {

    public static ItemStack addItem(String itemName, String skullOwnerName) {

        final ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        final SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
        itemmeta.setOwner(skullOwnerName);
        itemmeta.setDisplayName(itemName);
        item.setItemMeta((ItemMeta) itemmeta);

        return item;

    }
}
