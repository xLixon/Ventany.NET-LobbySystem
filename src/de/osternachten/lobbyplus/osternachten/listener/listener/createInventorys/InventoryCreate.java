// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import de.osternachten.lobbyplus.osternachten.listener.listener.LobbyPlus;

public class InventoryCreate implements Listener
{
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
        this.inv = Bukkit.createInventory((InventoryHolder)null, 54);
        this.nameNavigator = "§cNavigator";
        this.Prefix = "§c[§2LobbySystem§c] | §5";
        this.displayNameSpawn = "§6Spawn";
        this.displayNameSkyWarsItem = "§aSkyWars";
        this.displayNameBedWarsItem = "§cBed§rWars";
        this.displayName1v1Item = "§d1v1";
        this.displayNameCBItem = "§5CityBuild";
        this.displayNameODV = "§2OneDayVaro";
    }
    
    
    
    
    
    
    
    @EventHandler
    public void naviTP(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        try {
            if (e.getInventory().getName().equalsIgnoreCase("§4Navigator")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
                    final String warp = LobbyPlus.instance.getConfig().getString("Warp.Name");
                    final String world = LobbyPlus.instance.getConfig().getString(".WORLD");
                    final double x = LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".X");
                    final double y = LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".Y");
                    final double z = LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".Z");
                    LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".PITCH");
                    LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".YAW");
                    final Location loc = new Location(Bukkit.getWorld(world), x, y, z);
                    p.teleport(loc);
                    p.closeInventory();
                    p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + "6 Du wurdest zu " + warp + " teleportiert.");
                }
            }
            if (e.getInventory().getName().equalsIgnoreCase("§aSkyWars")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.GRASS) {
                    final String warp = LobbyPlus.instance.getConfig().getString("Warp.Name");
                    final String world = LobbyPlus.instance.getConfig().getString(".WORLD");
                    final double x = LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".X");
                    final double y = LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".Y");
                    final double z = LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".Z");
                    LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".PITCH");
                    LobbyPlus.instance.getConfig().getDouble(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(warp)))))) + ".YAW");
                    final Location loc = new Location(Bukkit.getWorld(world), x, y, z);
                    p.teleport(loc);
                    p.closeInventory();
                    p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + "6 Du wurdest zu " + warp + " teleportiert.");
                }
            }
        }
        catch (Exception ex) {}
    }
}
