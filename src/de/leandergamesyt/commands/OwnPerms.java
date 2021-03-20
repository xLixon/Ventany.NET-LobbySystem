// 
// Decompiled by Procyon v0.5.36
// 

package de.leandergamesyt.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class OwnPerms implements CommandExecutor, Listener {
    String playername;

    public OwnPerms() {
        this.playername = Bukkit.getOnlinePlayers().getClass().getName();
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String lable, final String[] args) {
        final Player p = (Player) sender;
        if (args.length == 3) {
            if (args[0].equalsIgnoreCase("perms")) {
                p.sendMessage("§4Wrong Syntax:");
                p.sendMessage("§cSyntax: /perms {USERNAME} addperm {PERMISSION}");
            }
            args[1].equalsIgnoreCase("");
        }
        return false;
    }
}
