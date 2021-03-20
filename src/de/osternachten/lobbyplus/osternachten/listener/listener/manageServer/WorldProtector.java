package de.osternachten.lobbyplus.osternachten.listener.listener.manageServer;

import de.leandergamesyt.commands.BuildMode;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WorldProtector implements Listener {
    private static final String Prefix;

    public static boolean placeBlocks = false;
    public static boolean breakBlocks = placeBlocks;

    static {
        Prefix = "§cWorldProtector:§a ";
    }

    @EventHandler
    public void dontBreakBlocks(final BlockBreakEvent e) {

        final Player p = e.getPlayer();

        if (BuildMode.buildModePlayerList.contains(p.getName())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
            p.sendMessage(WorldProtector.Prefix + "§4Du darfst keine Bl\u00f6cke zerstören!");
        }


    }

    @EventHandler
    public void dontPlaceBlocks(final BlockPlaceEvent e) {

        Player p = e.getPlayer();

        if (BuildMode.buildModePlayerList.contains(p.getName())) {
            return;
        } else {
            e.setCancelled(true);
            p.sendMessage(WorldProtector.Prefix + "§4Du darfst keine Bl\u00f6cke platzieren!");
        }


    }

    @EventHandler
    public void onDisconnectClear(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        p.getInventory().clear();
    }

    @EventHandler
    public void onDamage(final EntityDamageByEntityEvent e) {
        if (e.getEntityType() == EntityType.PLAYER) {
            final Player p = (Player) e.getEntity();
            e.setCancelled(true);
            p.setHealth(20.0);
        }
    }

    @EventHandler
    public void noFallDamage(final EntityDamageByBlockEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void noHunger(final FoodLevelChangeEvent e) {
        if (e.getEntityType() == EntityType.PLAYER) {
            final Player p = (Player) e.getEntity();
            p.setFoodLevel(20);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void noItmInvMove(final InventoryClickEvent e) {
        if (BuildMode.buildModePlayerList.contains(e.getWhoClicked().getName())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void noItmDrop(final PlayerDropItemEvent e) {
        if (BuildMode.buildModePlayerList.contains(e.getPlayer().getName())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void noMobSpawn(final EntitySpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void entityDamage(final EntityDamageEvent e) {
        if (e.getEntity() instanceof CraftPlayer) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void noAchivements(final PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }
}
