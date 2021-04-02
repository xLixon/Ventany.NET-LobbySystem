package de.osternachten.lobbyplus.osternachten.listener.listener.scoreboards;

import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.lib.player.permission.GroupEntityData;
import de.osternachten.lobbyplus.osternachten.listener.listener.LobbyPlus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Map;

public class ScoreboardSidebar implements Listener {

    String serverName = LobbyPlus.serverName;
    private final LobbyPlus plugin = LobbyPlus.getInstance();
    boolean firstJoin;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        firstJoin = true;

        Player p = e.getPlayer();

        Scoreboard board = p.getScoreboard();

        GroupEntityData cloudNetPlayer = CloudAPI.getInstance().getOnlinePlayer(p.getUniqueId()).getPermissionEntity().getGroups().toArray(new GroupEntityData[1])[0];
        Map<String, Object> perm = CloudAPI.getInstance().getPermissionGroup(cloudNetPlayer.getGroup()).getOptions();

        if (board != null) {
            Objective playerCount = board.getObjective(serverName);
            if (playerCount == null) {
                playerCount = board.registerNewObjective(serverName, "dummy");
            }
            playerCount.getScore("§7").setScore(14);
            playerCount.getScore("Rank§7:").setScore(13);
            playerCount.getScore(perm.get("color") + cloudNetPlayer.getGroup()).setScore(12);
            playerCount.getScore("").setScore(11);
            playerCount.getScore("Coins§7:").setScore(10);
            playerCount.getScore("§eCOINS").setScore(9);
            playerCount.getScore("§6").setScore(8);
            playerCount.getScore("Clan§7:").setScore(7);
            playerCount.getScore("CLAN").setScore(6);
            playerCount.getScore("§e").setScore(5);
            playerCount.getScore("Freunde§7:").setScore(4);
            playerCount.getScore("§ax§7/§cx").setScore(3);
            playerCount.getScore("§a").setScore(2);
            playerCount.getScore("Online Spieler Anzahl:").setScore(1);
            playerCount.getScore("§a" + CloudAPI.getInstance().getOnlinePlayers().size() + " §7User").setScore(0);

            playerCount.setDisplaySlot(DisplaySlot.SIDEBAR);
            final int[] i = {0};
            final int[] i2 = {0};

            if (!firstJoin) {
                plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        board.getObjective(serverName).getScore("§a" + CloudAPI.getInstance().getOnlinePlayers().size() + " §7User").setScore(0);
                        i[0]++;
                        Bukkit.broadcastMessage("§a" + i[0] + "");

                    }
                }, 0, 10);
                plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        board.getObjective(serverName).getScore(perm.get("color") + cloudNetPlayer.getGroup()).setScore(12);
                        i2[0]++;
                        Bukkit.broadcastMessage("§c" + i2[0] + "");

                    }
                }, 0, 100);
            }


        }
    }

    @EventHandler
    public void changeOnPlayers(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        Scoreboard board = p.getScoreboard();

        if (board != null) {
            Objective playerCount = board.getObjective(serverName);
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.getScoreboard().getObjective(serverName).getScore("§a" + CloudAPI.getInstance().getOnlinePlayers().size() + " §7User").setScore(0);
            }
            playerCount.getScore("§a" + CloudAPI.getInstance().getOnlinePlayers().size() + " §7User").setScore(0);
        }

    }


    @EventHandler
    public void changeOnPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Scoreboard board = p.getScoreboard();

        if (board != null) {
            Objective playerCount = board.getObjective(serverName);
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.getScoreboard().getObjective(serverName).getScore("§a" + CloudAPI.getInstance().getOnlinePlayers().size() + " §7User").setScore(0);
            }

        }

    }
}
