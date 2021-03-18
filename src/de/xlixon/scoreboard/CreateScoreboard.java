// 
// Decompiled by Procyon v0.5.36
// 

package de.xlixon.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_8_R3.Scoreboard;

public class CreateScoreboard implements Listener
{
    int i;
    int i2;
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        for (final Player all : Bukkit.getOnlinePlayers()) {
            all.setCustomName(String.valueOf(all.getName()) + " | " + this.i);
            ++this.i;
            p.sendMessage("Deine ID: " + p.getCustomName());
        }
        final Scoreboard board = new Scoreboard();
        board.addPlayerToTeam("xLixon", "");
        for (final Player all2 : Bukkit.getOnlinePlayers()) {
            if (all2.getName() != all2.getCustomName()) {
                return;
            }
            ++this.i;
        }
    }
}
