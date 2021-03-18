// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.listener.listener.navigator;

import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.Listener;

public class TeleportCityBuild implements Listener
{
    Inventory inv;
    String nameNavigator;
    String Prefix;
    String displayNameSpawn;
    String displayNameSkyWarsItem;
    String displayNameBedWarsItem;
    String displayName1v1Item;
    String displayNameCBItem;
    String displayNameCoresItem;
    String displayNameSpeedUHCItem;
    String displayNameEGItem;
    String displayNameTTTItem;
    String displayNameJARItem;
    String displayNameGunGameItem;
    String displayNameFFAItem;
    String displayNameGame1v1Item;
    String displayNameKit1v1Item;
    String displayNameSGItem;
    String displayNameCommunity;
    String displayNameLounge;
    
    public TeleportCityBuild() {
        this.inv = Bukkit.createInventory((InventoryHolder)null, 54);
        this.nameNavigator = "�cNavigator";
        this.Prefix = "�c[�2LobbySystem�c] | �5";
        this.displayNameSpawn = "�6Spawn";
        this.displayNameSkyWarsItem = "�aSkyWars";
        this.displayNameBedWarsItem = "�cBed�rWars";
        this.displayName1v1Item = "�d1v1";
        this.displayNameCBItem = "�5CityBuild";
        this.displayNameCoresItem = "�b�lCores";
        this.displayNameSpeedUHCItem = "�e�lSpeedUHC";
        this.displayNameEGItem = "�5�lEnderGa,es";
        this.displayNameTTTItem = "�4�lTTT";
        this.displayNameJARItem = "�c�lJumpAndRun";
        this.displayNameGunGameItem = "�3�lGunGame";
        this.displayNameFFAItem = "�d�lFFA";
        this.displayNameGame1v1Item = "�1�lGame 1vs1";
        this.displayNameKit1v1Item = "�1�lKit 1vs1";
        this.displayNameSGItem = "�a�lSurvivalGames";
        this.displayNameCommunity = "�5�lCommunity";
        this.displayNameLounge = "�6�lLounge";
    }
    
    @EventHandler
    public void invClickSPTP(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getClickedInventory().contains(Material.WORKBENCH)) {
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object)Material.AIR)) {
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.displayNameCBItem)) {
                    final YamlConfiguration spawnPointConfig = YamlConfiguration.loadConfiguration(new File("plugins/LobbySystem/config.yml"));
                    final Object X = spawnPointConfig.get("navicb.X");
                    final Object Y = spawnPointConfig.get("navicb.Y");
                    final Object Z = spawnPointConfig.get("navicb.Z");
                    final Object world = spawnPointConfig.get("navicbv.WORLD");
                    final Object yaw = spawnPointConfig.get("navicb.YAW");
                    if (!(X instanceof Double)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "�2Location: CityBuild" + " " + "�rDer Wert \"X\" ist �4KEINE �r Zahl.");
                        return;
                    }
                    if (!(Y instanceof Double)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "�2Location: CityBuild" + " " + "Der Wert \"Y\" ist �4KEINE �r Zahl.");
                        return;
                    }
                    if (!(Z instanceof Double)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "�2Location: CityBuild" + " " + "Der Wert \"Z\" ist �4KEINE �r Zahl.");
                        return;
                    }
                    if (!(world instanceof String)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "�2Location: CityBuild" + " " + "Der Wert \"world\" ist �4KEIN �r Name.");
                        return;
                    }
                    if (!(yaw instanceof Double)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "�2Location: CityBuild" + " " + "Der Wert \"yaw\" ist �4KEINE �r Zahl.");
                        return;
                    }
                    if (Bukkit.getWorld((String)world) != null) {
                        p.teleport(new Location(Bukkit.getWorld((String)world), (double)X, (double)Y, (double)Z, (float)Math.floor((double)yaw), 0.0f));
                    }
                    else {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "�2Location: CityBuild" + " " + "�cDiese Welt gibt es nicht!");
                    }
                }
            }
        }
    }
}