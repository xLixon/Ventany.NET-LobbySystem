package de.leandergamesyt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import de.apis.ChangeName;
import de.osternachten.lobbyplus.osternachten.listener.listener.LobbyPlus;

public class Nick implements Listener, CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("Sorry, aber nur Spieler können sich nicken.");
		}else {
			Player p = (Player) sender;
			
			if(!(p.hasPermission("lobby.nick"))) {
				p.sendMessage(LobbyPlus.noPermsError);
			}else {
				ChangeName.changeName(args[0], p);
				p.setPlayerListName(args[0]);
			}
			
		}
		
		return false;
	}

}
