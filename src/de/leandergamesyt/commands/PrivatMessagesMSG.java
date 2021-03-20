package de.leandergamesyt.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrivatMessagesMSG implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (Bukkit.getPlayer(args[0]) == null) {
            if (!(sender instanceof Player)) {
                Player recipient = (Player) Bukkit.getPlayer(args[0]);
                recipient.sendMessage("MSG from: " + sender.getName() + "\n" + String.join(label, args));
            }

            sender.sendMessage("Dieser Spieler ist nicht online!");
        } else {
            Player recipient = (Player) Bukkit.getPlayer(args[0]);
            Player sender_p = (Player) sender;
            String[] msg = {String.join(" ", args)};

            recipient.sendMessage("§cNew MSG from: " + sender_p.getName() + "\n" + msg.toString());
            sender_p.sendMessage("\n\nMSG sendt.");
        }

        return false;
    }

}
