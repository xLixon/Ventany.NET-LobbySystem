// 
// Decompiled by Procyon v0.5.36
// 

package de.leandergamesyt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CMD_Heal implements CommandExecutor, Listener {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lable, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Bitte gib einen g\u00fcltigen Spieler an.");
        }
        final Player p = (Player) sender;
        if (args.length == 0) {
            if (p.hasPermission("lobbysystem.perm.heal")) {
                p.setHealth(20.0);
                p.setFoodLevel(20);
                p.sendMessage("§eDu wurdest erfolgreich gehealed.");
            } else {
                p.sendMessage("§3Dazu hast du nicht die Berechtigung!");
            }
        } else {
            p.sendMessage("§4Bitte benutzte /heal");
        }
        return true;
    }
}
