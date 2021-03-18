// 
// Decompiled by Procyon v0.5.36
// 

package de.leandergamesyt.commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class PlayerPrefix implements Listener, CommandExecutor
{
    public String playerPrefix;
    public String msg;
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("permission.lobby.change.prefix") && args.length >= 1) {
            this.playerPrefix = args[0];
            if (this.playerPrefix == null) {
                p.sendMessage("Es wurde noch kein Prefix gesetzt.");
            }
            p.setCustomName(String.valueOf(this.playerPrefix) + p.getCustomName());
            p.sendMessage("Dein Neuer Name: " + p.getCustomName());
        }
        return false;
    }
}
