// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class InvSpecialCreate implements Listener {
    String invHats;

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        this.invHats = "§cH\u00fcte";
        final ItemStack invHats = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        final SkullMeta itemmetaInvHats = (SkullMeta) invHats.getItemMeta();
        itemmetaInvHats.setOwner(p.getName());
        itemmetaInvHats.setDisplayName(this.invHats);
        invHats.setItemMeta((ItemMeta) itemmetaInvHats);
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if (!(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.invHats))) {
                return;
            } else {
                Bukkit.createInventory((InventoryHolder) p, 36);
            }
        }
    }
}
