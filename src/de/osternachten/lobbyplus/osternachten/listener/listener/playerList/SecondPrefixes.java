// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.playerList;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import java.util.ArrayList;
import org.bukkit.event.Listener;

public class SecondPrefixes implements Listener
{
    public static ArrayList<PlayerPrefix> prefixes;
    
    static {
        SecondPrefixes.prefixes = new ArrayList<PlayerPrefix>();
    }
    
    public static void init() {
        registerPrefix("§7Spieler | ", "lobby.player");
    }
    
    public static void registerPrefix(final String prefix, final String permission) {
        SecondPrefixes.prefixes.add(new PlayerPrefix(prefix, permission));
    }
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent e, final Player p) {
        this.addPrefix(e.getPlayer());
    }
    
    public String getPrefixOfPlayer(final Player p) {
        for (final PlayerPrefix pp : SecondPrefixes.prefixes) {
            if (pp.hasPrefix(p)) {
                return pp.prefix;
            }
        }
        return null;
    }
    
    public boolean addPrefix(final Player p) {
        final String prefix = this.getPrefixOfPlayer(p);
        if (prefix != null) {
            p.setCustomName(String.valueOf(prefix) + p.getName());
            p.setDisplayName(String.valueOf(prefix) + p.getName());
            p.setPlayerListName(String.valueOf(prefix) + p.getName());
        }
        return prefix != null;
    }
    
    public static class PlayerPrefix
    {
        public String permission;
        public String prefix;
        
        public PlayerPrefix(final String prefix, final String permission) {
            this.permission = permission;
            this.prefix = prefix;
        }
        
        public boolean hasPrefix(final Player p) {
            return p.hasPermission(this.permission);
        }
    }
}
