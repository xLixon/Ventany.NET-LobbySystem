// 
// Decompiled by Procyon v0.5.36
// 

package de.leandergamesyt.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class Wartungsmodus implements Listener, CommandExecutor {
    boolean wartungsmodus;
    int timer;

    public Wartungsmodus() {
        this.wartungsmodus = false;
        this.timer = 1;
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        if (this.wartungsmodus) {
            if (!p.hasPermission("lobby.wartungsmodus.bypass")) {
                p.kickPlayer("§cDie Wartung ist aktuell aktiv. \n§eBitte versuche es sp\u00e4ter erneut");
            } else {
                p.sendMessage("§cDie Wartung ist aktuell aktiv, du hast aber die Permission zum ByPass.");
            }
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onLogin(final AsyncPlayerPreLoginEvent event) {
        if (this.wartungsmodus) {
            for (final OfflinePlayer op : Bukkit.getWhitelistedPlayers()) {
                if (op.getName().equalsIgnoreCase(event.getName())) {
                    return;
                }
            }
            if (!Bukkit.getOfflinePlayer(event.getName()).isOp()) {
                event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "§4Der Server ist im WartungsModus!");
            }
        }
    }

    @EventHandler
    public void onPing(final ServerListPingEvent event) {
        if (this.wartungsmodus) {
            event.setMaxPlayers(0);
            event.setMotd("§4Der Server ist im WartungsModus!");
        }
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!command.getName().equalsIgnoreCase("wartungsmodus")) {
            return false;
        }
        if (!sender.hasPermission("wartungsmodus") && !sender.isOp()) {
            return false;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("an")) {
                this.wartungsmodus = true;
                sender.sendMessage("§aDu hast den Wartungs-Modus aktiviert!");
            }
            if (args[0].equalsIgnoreCase("aus")) {
                this.wartungsmodus = false;
                sender.sendMessage("§4Du hast den Wartungs-Modus deaktiviert!");
            }
            return true;
        }
        return false;
    }
}
