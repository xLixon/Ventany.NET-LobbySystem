package de.lobbyplus.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SaveNick implements Listener{
	
	public static String playerNick;
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() != Material.NAME_TAG) {
			e.setCancelled(true);
		}else {
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Nick-Tool")) {
				playerNick = p.getPlayerListName();
				Bukkit.getLogger().info("New Nick save: " + playerNick);
			}
		}
		
		
		
		
		
	}

}
