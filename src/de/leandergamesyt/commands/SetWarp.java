// 
// Decompiled by Procyon v0.5.36
// 

package de.leandergamesyt.commands;

import de.osternachten.lobbyplus.osternachten.listener.listener.LobbyPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetWarp implements CommandExecutor, Listener
{
    String Prefix;
    
    public SetWarp() {
        this.Prefix = "§c[§2LobbySystem§c] | §5";
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        final Player player = (Player)sender;
        if (!player.hasPermission("lobbysystem.permission.setwarp.spawn")) {
            return false;
        }
        if (args.length != 1) {
            player.sendMessage("Das sind zu wenig Argumente.");
            player.sendMessage("Bitte versuche es noch einmal");
            player.sendMessage("Syntax: /setwarp [warpname]");
            return false;
        }
        final String warpName = args[0];
        LobbyPlus.instance.getConfig().set("Warp.Name", (Object)warpName);
        LobbyPlus.instance.getConfig().set(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warpName)))).toLowerCase())) + ".X", (Object)player.getLocation().getX());
        LobbyPlus.instance.getConfig().set(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warpName)))).toLowerCase())) + ".Y", (Object)player.getLocation().getY());
        LobbyPlus.instance.getConfig().set(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warpName)))).toLowerCase())) + ".Z", (Object)player.getLocation().getZ());
        LobbyPlus.instance.getConfig().set(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warpName)))).toLowerCase())) + ".YAW", (Object)player.getLocation().getYaw());
        LobbyPlus.instance.getConfig().set(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warpName)))).toLowerCase())) + ".PITCH", (Object)player.getLocation().getPitch());
        LobbyPlus.instance.getConfig().set(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warpName)))).toLowerCase())) + ".WORLD", (Object)player.getWorld().getName());
        LobbyPlus.instance.saveConfig();
        player.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "Der Warp f\u00fcr " + "§c" + warpName + "§r" + " wurde gesetzt");
        return true;
    }
}
