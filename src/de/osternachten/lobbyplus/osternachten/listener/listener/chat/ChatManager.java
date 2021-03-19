// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.Locale;

public class ChatManager implements Listener {

    @EventHandler
    public void checkPlayerMessage(AsyncPlayerChatEvent e) {

        ArrayList<String> badWords = new ArrayList<String>();
        badWords.add("testHallo");

        Player p = e.getPlayer();

        if (e.getMessage().toLowerCase(Locale.ROOT).contains((CharSequence) badWords)) {
            p.sendMessage("Du wurdest aus dem Chat gemuted!");
            e.setMessage("Böse Nachricht von " + p.getName() + " wurde blockiert!");
        }


    }
}
