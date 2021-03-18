// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.extras;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class SecretListener implements Listener
{
    String displayNameSecret;
    
    public SecretListener() {
        this.displayNameSecret = "§9Wow, ein Secret";
    }
    
    public void secretIndicator(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if ((e.isLeftClick() || e.isRightClick()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.displayNameSecret)) {
            p.sendMessage("Uiii");
        }
    }
}
