// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys;

import de.osternachten.lobbyplus.osternachten.listener.listener.LobbyPlus;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.logging.Level;

public class InventoryCreate implements Listener {
    private final Location naviSpawn;
    Inventory inv;
    String nameNavigator;
    String Prefix;
    String displayNameSpawn;
    String displayNameSkyWarsItem;
    String displayNameBedWarsItem;
    String displayName1v1Item;
    String displayNameCBItem;
    String displayNameODV;
    String displayName;

    public InventoryCreate() {
        this.inv = Bukkit.createInventory((InventoryHolder) null, 54);
        this.nameNavigator = "§cNavigator";
        this.Prefix = "§c[§2LobbySystem§c] | §5";
        this.displayNameSpawn = "§6Spawn";
        this.displayNameSkyWarsItem = "§aSkyWars";
        this.displayNameBedWarsItem = "§cBed§rWars";
        this.displayName1v1Item = "§d1v1";
        this.displayNameCBItem = "§5CityBuild";
        this.displayNameODV = "§2OneDayVaro";
        this.naviSpawn = loadWarp("navispawn");
    }

    public Location loadWarp(String warpName) {
        String world = LobbyPlus.instance.getConfig().getString(warpName + ".WORLD");
        double x = LobbyPlus.instance.getConfig().getDouble(warpName + ".X");
        double y = LobbyPlus.instance.getConfig().getDouble(warpName + ".Y");
        double z = LobbyPlus.instance.getConfig().getDouble(warpName + ".Z");
        double yaw = LobbyPlus.instance.getConfig().getDouble(warpName + ".YAW");
        double pitch = LobbyPlus.instance.getConfig().getDouble(warpName + ".PITCH");

        return new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch);
    }


    @EventHandler
    public void naviTP(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        try {
            if (e.getInventory().getName().equalsIgnoreCase("§4Navigator")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
                    p.teleport(this.naviSpawn);
                    p.closeInventory();
                    p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + "§6 Du wurdest zum Spawn teleportiert.");
                }
            }

        } catch (Exception ex) {
            Bukkit.getLogger().log(Level.WARNING, "§4Plugin gecrashed", ex);
            Bukkit.getPluginManager().disablePlugin(LobbyPlus.instance);

        }


    }
}
