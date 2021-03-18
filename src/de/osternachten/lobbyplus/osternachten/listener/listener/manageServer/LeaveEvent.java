// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.manageServer;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener
{
    public void onLeave(final PlayerQuitEvent e) {
        e.setQuitMessage(" ");
        final Player p = e.getPlayer();
        p.getInventory().clear();
    }
}
