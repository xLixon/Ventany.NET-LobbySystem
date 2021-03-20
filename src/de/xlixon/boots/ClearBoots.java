// 
// Decompiled by Procyon v0.5.36
// 

package de.xlixon.boots;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClearBoots implements Listener {
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if (e.getClickedInventory().contains(Material.BARRIER) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBoots ablegen")) {
                final Player p = (Player) e.getWhoClicked();
                p.getInventory().setBoots((ItemStack) null);
                p.closeInventory();
            }
        }
    }
}
