
package de.osternachten.lobbyplus.osternachten.listener.listener.chat;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColorRed implements Listener {
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent e) {
        e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
    }
}
