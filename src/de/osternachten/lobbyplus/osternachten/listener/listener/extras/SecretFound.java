// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.extras;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class SecretFound implements Listener
{
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getClickedInventory().getTitle().equalsIgnoreCase("") && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u00c2§9Wow, ein Secret")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            p.sendMessage("Hi");
        }
    }
}
