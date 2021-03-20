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

public class LavaBoots implements Listener {
    String lavaBootsName;
    Boolean toggle;

    public LavaBoots() {
        this.toggle = false;
    }

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        this.lavaBootsName = "§4Lava Boots";
        final Player p = (Player) e.getWhoClicked();
        final ItemStack lavaBoots = new ItemStack(Material.LEATHER_BOOTS);
        final LeatherArmorMeta lavaBootsMeta = (LeatherArmorMeta) lavaBoots.getItemMeta();
        lavaBootsMeta.setColor(Color.RED);
        lavaBootsMeta.setDisplayName(this.lavaBootsName);
        lavaBoots.setItemMeta((ItemMeta) lavaBootsMeta);
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if (e.getClickedInventory().contains(Material.LEATHER_BOOTS) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.lavaBootsName)) {
                p.getInventory().setBoots(lavaBoots);
                p.closeInventory();
            }
        }
    }
}
