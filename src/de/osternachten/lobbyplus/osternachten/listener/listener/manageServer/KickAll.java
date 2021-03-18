// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.manageServer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class KickAll implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lable, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Bitte gib einen g\u00fcltigen Spieler an.");
        }
        final Player p = (Player)sender;
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("kickall") && args[1].equalsIgnoreCase("confirm")) {
                if (p.hasPermission("lobby.kickall")) {
                    for (final Player sender2 : Bukkit.getOnlinePlayers()) {
                        sender2.kickPlayer("§cAlle Spieler wurden vom Server gekickt. \n§r§eVeranlasser des Kickens: §4" + sender.getName());
                    }
                }
                else {
                    p.sendMessage("§3Dazu hast du nicht die Berechtigung!");
                }
            }
        }
        else {
            p.sendMessage("§4Bitte benutzte /kickall kickall confirm");
            p.sendMessage("§4Doppelt f\u00fcr sicherheit lmao");
        }
        return true;
    }
}
