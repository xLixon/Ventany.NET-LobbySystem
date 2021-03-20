package de.osternachten.lobbyplus.osternachten.listener.listener.scoreboards;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardSidebar implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Scoreboard board = p.getScoreboard();

        if (board != null) {
            Objective playerCount = board.getObjective("§4§lVentany.NET");
            if (playerCount == null) {
                playerCount = board.registerNewObjective("§4§lVentany.NET", "dummy");


            }
            playerCount.getScore("§7-----------").setScore(1);
            playerCount.getScore("§aWillkommen").setScore(0);
            playerCount.getScore(ChatColor.AQUA + p.getName()).setScore(-1);
            playerCount.getScore("§7-----------").setScore(-2);
            playerCount.getScore("§cDein Rang:").setScore(0);
            playerCount.getScore("§4").setScore(-1);
            playerCount.getScore("§7-----------").setScore(-2);
            playerCount.getScore("Dein Ping:").setScore(-3);
            playerCount.getScore("[ping]").setScore(-4);
            playerCount.getScore("§7-----------").setScore(-5);
            playerCount.setDisplaySlot(DisplaySlot.SIDEBAR);
        }


    }

}
