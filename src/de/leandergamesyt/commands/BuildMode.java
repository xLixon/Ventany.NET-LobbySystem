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

        System.out.println("1");

        if (!(sender instanceof Player)) {
            System.out.println("2");
            sender.sendMessage("§7[§e!§7]§c Du musst ein Spieler sein, um in den BuildMode zu gehen!");
        } else {
            System.out.println("3");

            Player p = (Player) sender;

            if (!(p.hasPermission("build.change"))) {
                System.out.println("4");
                p.sendMessage(LobbyPlus.noPermsError);
            } else {
                System.out.println("5");
                if (buildModePlayerList.contains(p.getName())) {
                    System.out.println("6");
                    buildModePlayerList.remove(p.getName());
                    p.sendMessage("§7[§e!§7]§c Du bist nicht mehr im BuildMode!");
                } else {
                    System.out.println("7");
                    buildModePlayerList.add(p.getName());
                    p.sendMessage("§7[§e!§7]§c Du bist jetzt im BuildMode!");
                }

            }

        }

        return false;


    }

}
