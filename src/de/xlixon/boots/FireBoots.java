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

public class FireBoots implements Listener {
    String FireBootsName;
    Boolean toggle;

    public FireBoots() {
        this.toggle = false;
    }

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        this.FireBootsName = "§cFire Boots";
        final Player p = (Player) e.getWhoClicked();
        final ItemStack FireBoots = new ItemStack(Material.LEATHER_BOOTS);
        final LeatherArmorMeta fireBootsMeta = (LeatherArmorMeta) FireBoots.getItemMeta();
        fireBootsMeta.setColor(Color.ORANGE);
        fireBootsMeta.setDisplayName(this.FireBootsName);
        FireBoots.setItemMeta((ItemMeta) fireBootsMeta);
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if (e.getClickedInventory().contains(Material.LEATHER_BOOTS) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cFire Boots")) {
                p.getInventory().setBoots(FireBoots);
                p.closeInventory();
            }
        }
    }
}
