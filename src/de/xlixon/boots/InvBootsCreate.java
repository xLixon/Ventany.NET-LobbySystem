// 
// Decompiled by Procyon v0.5.36
// 

package de.xlixon.boots;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class InvBootsCreate implements Listener
{
    String loveBootsName;
    String waterBootsName;
    String fireBootsName;
    String lavaBootsName;
    String clearBoots;
    
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        this.loveBootsName = "§dLove Boots";
        this.waterBootsName = "§bWater Boots";
        this.fireBootsName = "§cFire Boots";
        this.lavaBootsName = "§4Lava Boots";
        this.clearBoots = "§cBoots ablegen";
        final Player p = (Player)e.getWhoClicked();
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getClickedInventory().contains(Material.GOLD_BOOTS)) {
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object)Material.AIR)) {
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBoots")) {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 18, "§eBoots");
                    final ItemStack loveBoots = new ItemStack(Material.LEATHER_BOOTS);
                    final LeatherArmorMeta loveBootsMeta = (LeatherArmorMeta)loveBoots.getItemMeta();
                    loveBootsMeta.setColor(Color.PURPLE);
                    loveBootsMeta.setDisplayName(this.loveBootsName);
                    loveBoots.setItemMeta((ItemMeta)loveBootsMeta);
                    final ItemStack waterBoots = new ItemStack(Material.LEATHER_BOOTS);
                    final LeatherArmorMeta waterBootsMeta = (LeatherArmorMeta)waterBoots.getItemMeta();
                    waterBootsMeta.setColor(Color.BLUE);
                    waterBootsMeta.setDisplayName(this.waterBootsName);
                    waterBoots.setItemMeta((ItemMeta)waterBootsMeta);
                    final ItemStack fireBoots = new ItemStack(Material.LEATHER_BOOTS);
                    final LeatherArmorMeta fireBootsMeta = (LeatherArmorMeta)fireBoots.getItemMeta();
                    fireBootsMeta.setColor(Color.ORANGE);
                    fireBootsMeta.setDisplayName(this.fireBootsName);
                    fireBoots.setItemMeta((ItemMeta)fireBootsMeta);
                    final ItemStack lavaBoots = new ItemStack(Material.LEATHER_BOOTS);
                    final LeatherArmorMeta lavaBootsMeta = (LeatherArmorMeta)lavaBoots.getItemMeta();
                    lavaBootsMeta.setColor(Color.RED);
                    lavaBootsMeta.setDisplayName(this.lavaBootsName);
                    lavaBoots.setItemMeta((ItemMeta)lavaBootsMeta);
                    final ItemStack ClearBoots = new ItemStack(Material.BARRIER);
                    final ItemMeta itemmetaClear = ClearBoots.getItemMeta();
                    itemmetaClear.setDisplayName(this.clearBoots);
                    ClearBoots.setItemMeta(itemmetaClear);
                    inv.setItem(0, loveBoots);
                    inv.setItem(1, waterBoots);
                    inv.setItem(2, fireBoots);
                    inv.setItem(3, lavaBoots);
                    inv.setItem(9, ClearBoots);
                    p.openInventory(inv);
                    p.sendMessage("§4Die Partikel funktionieren im Moment nicht richtig.");
                    p.sendMessage("§4Dieses Feature muss noch einprogrammiert werden.");
                }
            }
        }
    }
}
