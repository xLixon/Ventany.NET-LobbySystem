// 
// Decompiled by Procyon v0.5.36
// 

package de.lobbyplus.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class Shield implements Listener
{
    String Shield_ON;
    String Shield_ON_ON;
    String Shield_OFF;
    String Shield_OFF_OFF;
    String Prefix;
    public ArrayList<Player> shieldedPlayers;
    
    public Shield() {
        this.Shield_ON = "§5§lSchutzschild §r[§2§lEIN§r]";
        this.Shield_ON_ON = "§r[§2§lEIN§r]";
        this.Shield_OFF = "§5§lSchutzschild §r[§4§lAUS§r]";
        this.Shield_OFF_OFF = "§r[§4§lAUS§r]";
        this.Prefix = "§c[§2Lobby§c] | §5";
        this.shieldedPlayers = new ArrayList<Player>();
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            final Player p = e.getPlayer();
            if (e.getItem() == null) {
                return;
            }
            if (e.getItem().getType() == Material.EYE_OF_ENDER) {
                final ItemStack shield = p.getItemInHand();
                final ItemMeta shieldmeta = shield.getItemMeta();
                if (shieldmeta.getDisplayName() == this.Shield_ON) {
                    shieldmeta.setDisplayName(this.Shield_OFF);
                    p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + "Dein Schild ist jetzt " + this.Shield_OFF_OFF);
                    this.shieldedPlayers.remove(p);
                }
                else {
                    shieldmeta.setDisplayName(this.Shield_ON);
                    p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + "Dein Schild ist jetzt " + this.Shield_ON_ON);
                    this.shieldedPlayers.add(p);
                }
                shield.setItemMeta(shieldmeta);
            }
        }
    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (this.shieldedPlayers.contains(p)) {
            for (final Player otherPlayers : Bukkit.getOnlinePlayers()) {
                if (otherPlayers != p && otherPlayers.getLocation().distanceSquared(p.getLocation()) <= 7.0) {
                    final double x = otherPlayers.getLocation().getX() - p.getLocation().getX();
                    final double y = otherPlayers.getLocation().getY() - p.getLocation().getY();
                    final double z = otherPlayers.getLocation().getZ() - p.getLocation().getZ();
                    otherPlayers.setVelocity(new Vector(x, y, z).normalize().multiply(2).setY(0.3));
                }
            }
        }
        else {
            for (final Player otherPlayers : this.shieldedPlayers) {
                if (p.getLocation().distanceSquared(otherPlayers.getLocation()) <= 7.0) {
                    final double x = p.getLocation().getX() - otherPlayers.getLocation().getX();
                    final double y = p.getLocation().getY() - otherPlayers.getLocation().getY();
                    final double z = p.getLocation().getZ() - otherPlayers.getLocation().getZ();
                    p.setVelocity(new Vector(x, y, z).normalize().multiply(2).setY(0.3));
                }
            }
        }
    }
}
