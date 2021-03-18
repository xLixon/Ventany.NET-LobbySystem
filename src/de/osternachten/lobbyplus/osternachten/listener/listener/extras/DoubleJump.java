package de.osternachten.lobbyplus.osternachten.listener.listener.extras;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener{
	
	@EventHandler
	public void doubleJump(PlayerToggleFlightEvent e) {
		
		Player p = e.getPlayer();
		
		if(p.getGameMode() == GameMode.CREATIVE) {
			p.setFlying(true);
		}else {
			p.setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.5).setY(5));
		}
		
	}

}
