// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.playerList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Prefix implements Listener {
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();

        final String prefix_Team_Owner_Chat = "§4Administrator ▎ §c" + p.getName() + " §7==>§r " + e.getMessage();

        final String prefix_Team_TeamLeitung_Chat = "§cTeam Leitung ▎ §c" + p.getName() + " §7==>§r \" + e.getMessage()";

        final String prefix_Team_Developer_Chat = "§bDeveloper ▎ §c" + p.getName() + " §7==>§r " + e.getMessage();

        final String prefix_Team_Moderator_Chat = "§cModerator ▎ " + p.getName() + " §7==>§r " + e.getMessage();

        final String prefix_Team_Supporter_Chat = "§3Supporter ▎ §c" + p.getName() + " §7==>§r " + e.getMessage();

        final String prefix_Team_Builder_Chat = "§2Builder ▎ §c" + p.getName() + " §7==>§r " + e.getMessage();

        final String prefix_Player_YouTuber_Chat = "§5YouTuber ▎ " + p.getName() + " §7==>§r " + e.getMessage();

        final String prefix_Player_PremiumPlus_Chat = "§ePremium+ ▎ " + p.getName() + " §7==>§r " + e.getMessage();

        final String prefix_Player_Premium_Chat = "§6Premium ▎ " + p.getName() + " §7==>§r " + e.getMessage();

        final String prefix_Player_Spieler_Chat = "§7Spieler ▎ " + p.getName() + " §7==>§r " + e.getMessage();


        if (p.hasPermission("lobby.owner")) {
            e.setFormat(prefix_Team_Owner_Chat);
        } else if (p.hasPermission("lobby.teamleitung")) {
            e.setFormat(prefix_Team_TeamLeitung_Chat);
            p.setPlayerListName(p.getCustomName());
        } else if (p.hasPermission("lobby.developer")) {
            e.setFormat(prefix_Team_Developer_Chat);
        } else if (p.hasPermission("lobby.moderator")) {
            e.setFormat(prefix_Team_Moderator_Chat);
        } else if (p.hasPermission("lobby.supporter")) {
            e.setFormat(prefix_Team_Supporter_Chat);
        } else if (p.hasPermission("lobby.supporter")) {
            e.setFormat(prefix_Team_Builder_Chat);
        } else if (p.hasPermission("lobby.YouTuber")) {
            e.setFormat(prefix_Player_YouTuber_Chat);
        } else if (p.hasPermission("lobby.premiplus")) {
            e.setFormat(prefix_Player_PremiumPlus_Chat);
        } else if (p.hasPermission("lobby.premium")) {
            e.setFormat(prefix_Player_Premium_Chat);
        } else {
            e.setFormat(prefix_Player_Spieler_Chat);
        }
    }

//    public static String prefix_Team_Owner_Tablist;
//    public String prefix_Team_TeamLeitung_Tablist;
//    public String prefix_Team_Developer_Tablist;
//    public String prefix_Team_Moderator_Tablist;
//    public String prefix_Team_Supporter_Tablist;
//    public String prefix_Team_Builder_Tablist;
//    public String prefix_Player_YouTuber_Tablist;
//    public String prefix_Player_PremiumPlus_Tablist;
//    public static String prefix_Player_Premium_Tablist;
//    public static String prefix_Player_Spieler_Tablist;
//
//
//    @EventHandler
//    public void onJoin(PlayerJoinEvent e) {
//
//        Player p = e.getPlayer();
//
//        prefix_Team_Owner_Tablist = "§4§lOwner | §c" + p.getName();
//        prefix_Team_TeamLeitung_Tablist = "§c§lTeam Leitung | §c" + p.getName();
//        prefix_Team_Developer_Tablist = "§bDeveloper | §c" + p.getName();
//        prefix_Team_Moderator_Tablist = "§cModerator | " + p.getName();
//        prefix_Team_Supporter_Tablist = "§3Supporter | " + p.getName();
//        prefix_Team_Builder_Tablist = "§2Builder | " + p.getName();
//        prefix_Player_YouTuber_Tablist = "§5YouTuber | " + p.getName();
//        prefix_Player_PremiumPlus_Tablist = "§ePremium+ | " + p.getName();
//        prefix_Player_Premium_Tablist = "§6Premium | " + p.getName();
//        prefix_Player_Spieler_Tablist = "§7Spieler | " + p.getName();
//        if (p.hasPermission("lobby.owner")) {
//            p.setPlayerListName(prefix_Team_Owner_Tablist);
//        } else if (p.hasPermission("lobby.teamleitung")) {
//            p.setCustomName(prefix_Team_TeamLeitung_Tablist);
//            p.setPlayerListName(p.getCustomName());
//        } else if (p.hasPermission("lobby.developer")) {
//            p.setPlayerListName(prefix_Team_Developer_Tablist);
//        } else if (p.hasPermission("lobby.moderator")) {
//            p.setPlayerListName(prefix_Team_Moderator_Tablist);
//        } else if (p.hasPermission("lobby.supporter")) {
//            p.setPlayerListName(prefix_Team_Supporter_Tablist);
//        } else if (p.hasPermission("lobby.supporter")) {
//            p.setPlayerListName(prefix_Team_Builder_Tablist);
//        } else if (p.hasPermission("lobby.YouTuber")) {
//            p.setPlayerListName(prefix_Player_YouTuber_Tablist);
//        } else if (p.hasPermission("lobby.premiplus")) {
//            p.setPlayerListName(prefix_Player_PremiumPlus_Tablist);
//        } else if (p.hasPermission("lobby.premium")) {
//            p.setPlayerListName(prefix_Player_Premium_Tablist);
//        } else {
//            p.setPlayerListName(prefix_Player_Spieler_Tablist);
//        }
//
//    }
}
