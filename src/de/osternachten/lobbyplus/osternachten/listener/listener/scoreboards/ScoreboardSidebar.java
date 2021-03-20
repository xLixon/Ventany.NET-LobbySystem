package de.osternachten.lobbyplus.osternachten.listener.listener.scoreboards;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardSidebar implements Listener {

    String serverName = "§lVENTANY.NET";

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        Scoreboard board = p.getScoreboard();

        if (board != null) {
            Objective playerCount = board.getObjective(serverName);
            if (playerCount == null) {
                playerCount = board.registerNewObjective(serverName, "dummy");


            }
            playerCount.getScore("§7").setScore(14);
            playerCount.getScore("Rank§7:").setScore(13);
            playerCount.getScore("§4").setScore(12);
            playerCount.getScore("").setScore(11);
            playerCount.getScore("Coins§7:").setScore(10);
            playerCount.getScore("§eCOINS").setScore(9);
            playerCount.getScore("§6").setScore(8);
            playerCount.getScore("Clan§7:").setScore(7);
            playerCount.getScore("CLAN").setScore(6);
            playerCount.getScore("§e").setScore(5);
            playerCount.getScore("Freunde§7:").setScore(4);
            playerCount.getScore("§ax§7/§cx").setScore(3);
            playerCount.setDisplaySlot(DisplaySlot.SIDEBAR);
        }


    }

}
