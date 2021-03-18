// 
// Decompiled by Procyon v0.5.36
// 

package de.lobbyplus.items;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;

public class Fly implements Listener
{
    String Prefix;
    String Fly_ON;
    String Fly_ON_ON;
    String Fly_OFF;
    public ArrayList<Player> flyPlayers;
    
    public Fly() {
        this.Prefix = "§c[§2Lobby§c] | §5";
        this.Fly_ON = "§a§lFlymode aktiviert";
        this.Fly_ON_ON = "§a§lFlymode aktiviert";
        this.Fly_OFF = "§4§lFlymode deaktiviert";
        this.flyPlayers = new ArrayList<Player>();
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            final Player p = e.getPlayer();
            if (e.getItem() == null) {
                return;
            }
            if (e.getItem().getType() == Material.FEATHER) {
                final ItemStack fly = p.getItemInHand();
                final ItemMeta flymeta = fly.getItemMeta();
                if (flymeta.getDisplayName() == this.Fly_ON) {
                    flymeta.setDisplayName(this.Fly_OFF);
                    p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + this.Fly_OFF);
                    this.flyPlayers.remove(p);
                    p.setAllowFlight(false);
                }
                else {
                    flymeta.setDisplayName(this.Fly_ON);
                    p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + this.Fly_ON);
                    this.flyPlayers.add(p);
                    p.setAllowFlight(true);
                }
                fly.setItemMeta(flymeta);
            }
        }
    }
}
