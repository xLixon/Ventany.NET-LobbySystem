package de.xlixon.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CleanChat implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        int i = 0;

        Player p = (Player) sender;

        if (p.hasPermission("lobby.clean.chat")) {
            while (i < 100) {
                Bukkit.broadcastMessage(" ");
                i++;
                if (i == 100) {
                    Bukkit.broadcastMessage("§c[§2Lobby§c] | §5 Chat wurde von " + sender.getName() + " gecleared");
                }
            }
        }

        return false;
    }

}
