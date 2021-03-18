// 
// Decompiled by Procyon v0.5.36
// 

package de.leandergamesyt.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GM1 implements CommandExecutor
{
    private String Prefix;
    
    public GM1() {
        this.Prefix = "§c[§2LobbySystem§c] | §5";
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            if (p.hasPermission("permission.lobby.gm")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§r§aDu bist jetzt im GAMEMODE " + p.getGameMode() + ".");
                    }
                    else if (args[0].equalsIgnoreCase("1")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§r§aDu bist jetzt im GAMEMODE " + p.getGameMode() + ".");
                    }
                    else if (args[0].equalsIgnoreCase("2")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§r§aDu bist jetzt im GAMEMODE " + p.getGameMode() + ".");
                    }
                    else if (args[0].equalsIgnoreCase("3")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§r§aDu bist jetzt im GAMEMODE " + p.getGameMode() + ".");
                    }
                    else {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§r§cEin Fehler ist aufgetreten.");
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§r§cSyntax: /gm [GAMEMODE | 1 / 2 / 3]");
                    }
                }
                else {
                    p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§r§cEin Fehler ist aufgetreten.");
                    p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§r§cSyntax: /gm [GAMEMODE | 1 / 2 / 3]");
                }
            }
            else {
                p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§r§cDu hast nicht genug Rechte f\u00fcr diesen Befehel.");
            }
        }
        return false;
    }
}
