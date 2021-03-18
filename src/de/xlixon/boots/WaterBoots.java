// 
// Decompiled by Procyon v0.5.36
// 

package de.xlixon.boots;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class WaterBoots implements Listener
{
    String waterBootsName;
    Boolean toggle;
    
    public WaterBoots() {
        this.toggle = false;
    }
    
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        this.waterBootsName = "§bWater Boots";
        final Player p = (Player)e.getWhoClicked();
        final ItemStack waterBoots = new ItemStack(Material.LEATHER_BOOTS);
        final LeatherArmorMeta waterBootsMeta = (LeatherArmorMeta)waterBoots.getItemMeta();
        waterBootsMeta.setColor(Color.BLUE);
        waterBootsMeta.setDisplayName(this.waterBootsName);
        waterBoots.setItemMeta((ItemMeta)waterBootsMeta);
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if (e.getClickedInventory().contains(Material.LEATHER_BOOTS) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bWater Boots")) {
                p.getInventory().setBoots(waterBoots);
                p.closeInventory();
            }
        }
    }
}
