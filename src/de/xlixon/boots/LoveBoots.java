// 
// Decompiled by Procyon v0.5.36
// 

package de.xlixon.boots;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class LoveBoots implements Listener
{
    String loveBootsName;
    Boolean toggle;
    
    public LoveBoots() {
        this.toggle = false;
    }
    
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        this.loveBootsName = "§dLove Boots";
        final Player p = (Player)e.getWhoClicked();
        final ItemStack loveBoots = new ItemStack(Material.LEATHER_BOOTS);
        final LeatherArmorMeta loveBootsMeta = (LeatherArmorMeta)loveBoots.getItemMeta();
        loveBootsMeta.setColor(Color.PURPLE);
        loveBootsMeta.setDisplayName(this.loveBootsName);
        loveBoots.setItemMeta((ItemMeta)loveBootsMeta);
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object)Material.AIR)) {
                return;
            }
            if (e.getClickedInventory().contains(Material.LEATHER_BOOTS) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dLove Boots")) {
                p.getInventory().setBoots(loveBoots);
                p.closeInventory();
            }
        }
    }
}
