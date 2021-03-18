// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.playerList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import net.minecraft.server.v1_8_R3.Packet;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import org.bukkit.entity.Player;
import java.io.File;

import org.bukkit.event.Listener;

public class Tab implements Listener
{
    String headerInhalt;
    String footerInhalt;
    String playerPing;
    String taber;
    String nameConfig;
    final Object Name;
    File f = new File("plugins/LobbySystem/tab.yml");
    
    public Tab(String nameConfig) {
    	
    	this.nameConfig = nameConfig;
		
		
		YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
		
        
        nameConfig = (String) config.get("Servername: ");
		
        this.Name = nameConfig;
		
        
    }
    
    @SuppressWarnings("rawtypes")
	public void sendTablistHeaderAndFooter(final Player p, String header, String footer) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
        this.footerInhalt = "";
        this.headerInhalt = "Dein Ping: ms";
        this.taber = "      ";
        if (header == null) {
            header = "";
        }
        if (footer == null) {
            footer = "";
        }
        final IChatBaseComponent tabHeader = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + header + "\"}");
        final IChatBaseComponent tabFooter = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + footer + "\"}");
        final PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(tabHeader);
        try {
            final Field field = headerPacket.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(headerPacket, tabFooter);
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        finally {
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)headerPacket);
        }
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)headerPacket);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)headerPacket);
    }
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
    	
    	System.out.println("Der aktuelle Servername: " + this.Name);
        final Player p = e.getPlayer();
        this.sendTablistHeaderAndFooter(p, "§e" + this.Name + " §2Lobby\n §7Du willst zu einem Spielmodi? Rechtsklick auf den Navigator!\n ", "§7Spiele mit deinen Freunden und habe Spa\u00df.\n §7Adde deine §aFreunde §7mit §a/friend §7und \n §7erstelle coole §5Partys §7mit §5/party\n");
    }
}
