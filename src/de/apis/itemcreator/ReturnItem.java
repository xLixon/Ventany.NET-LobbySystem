package de.apis.itemcreator;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ReturnItem {

    public static ItemStack addItem(Material mat, String itemName) {
        ItemStack item = new ItemStack(mat);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(itemName);
        item.setItemMeta(itemmeta);

        return item;

    }


}
