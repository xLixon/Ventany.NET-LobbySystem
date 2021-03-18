// 
// Decompiled by Procyon v0.5.36
// 

package de.xlixxn.hats;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CloseInv implements Listener
{
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if (e.getClickedInventory().contains(Material.BARRIER) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHat abnehmen")) {
                final Player p = (Player) e.getWhoClicked();
                p.getInventory().setHelmet((ItemStack) null);
                p.closeInventory();
            }
        }
    }
}
