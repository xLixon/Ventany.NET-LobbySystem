package de.leandergamesyt.commands;

import de.osternachten.lobbyplus.osternachten.listener.listener.LobbyPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;


public class BuildMode implements CommandExecutor {

    public static ArrayList<String> buildModePlayerList = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if (!(sender instanceof Player)) {
            sender.sendMessage("§7[§e!§7]§c Du musst ein Spieler sein, um in den BuildMode zu gehen!");
        } else {

            Player p = (Player) sender;

            if (!(p.hasPermission("build.change"))) {
                p.sendMessage(LobbyPlus.noPermsError);
            } else {
                if (buildModePlayerList.contains(p.getName())) {
                    buildModePlayerList.remove(p.getName());
                    p.sendMessage("§7[§e!§7]§c Du bist nicht mehr im BuildMode!");
                } else {
                    buildModePlayerList.add(p.getName());
                    p.sendMessage("§7[§e!§7]§c Du bist jetzt im BuildMode!");
                }

            }

        }

        return false;


    }

}
