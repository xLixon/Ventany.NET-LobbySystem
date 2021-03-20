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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SilentHub implements Listener {
    int silenthubstatus;
    String SilentHub_ON;
    String SilentHub_OFF;
    String Prefix;

    public SilentHub() {
        this.silenthubstatus = 0;
        this.SilentHub_ON = "§5§lSilent Hub §r[§2§lEIN§r]";
        this.SilentHub_OFF = "§5§lSilent Hub §r[§4§lAUS§r]";
        this.Prefix = "§c[§2Lobby§c] | §5";
    }

    public void showPlayer(final Player p) {
        for (final Player all : Bukkit.getOnlinePlayers()) {
            p.showPlayer(all);
        }
    }

    public void showVIP(final Player p) {
        for (final Player all : Bukkit.getOnlinePlayers()) {
            if (all.hasPermission("lobby.hide.vip")) {
                p.showPlayer(all);
            }
        }
    }

    public void hidePlayer(final Player p) {
        for (final Player all : Bukkit.getOnlinePlayers()) {
            p.hidePlayer(all);
        }
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            final Player p = e.getPlayer();
            if (e.getItem() == null) {
                return;
            }
            if (e.getItem().getType() == Material.TNT) {
                final ItemStack silenthub = p.getItemInHand();
                final ItemMeta silenthubdmeta = silenthub.getItemMeta();
                if (silenthubdmeta.getDisplayName() == this.SilentHub_ON) {
                    silenthubdmeta.setDisplayName(this.SilentHub_OFF);
                    p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + "Du bist jetzt nicht mehr auf der Silent Lobby!");
                    this.showPlayer(p);
                    e.setCancelled(true);
                } else {
                    silenthubdmeta.setDisplayName(this.SilentHub_ON);
                    p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + "Du bist jetzt auf der Silent Lobby!");
                    this.hidePlayer(p);
                    e.setCancelled(true);
                }
                silenthub.setItemMeta(silenthubdmeta);
            }
        }
    }
}
