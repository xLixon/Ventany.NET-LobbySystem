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

public class TeleportSkyWars implements Listener
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
    
    public TeleportSkyWars() {
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
    public void invClickSWTP(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getClickedInventory().contains(Material.GRASS)) {
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object)Material.AIR)) {
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.displayNameSkyWarsItem)) {
                    final YamlConfiguration spawnPointConfig = YamlConfiguration.loadConfiguration(new File("plugins/LobbySystem/config.yml"));
                    final Object X = spawnPointConfig.get("naviskywars.X");
                    final Object Y = spawnPointConfig.get("naviskywars.Y");
                    final Object Z = spawnPointConfig.get("naviskywars.Z");
                    final Object world = spawnPointConfig.get("naviskywars.WORLD");
                    final Object yaw = spawnPointConfig.get("naviskywars.YAW");
                    if (!(X instanceof Double)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§2Location: SkyWars" + " " + "§rDer Wert \"X\" ist §4KEINE §r Zahl.");
                        return;
                    }
                    if (!(Y instanceof Double)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§2Location: SkyWars" + " " + "Der Wert \"Y\" ist §4KEINE §r Zahl.");
                        return;
                    }
                    if (!(Z instanceof Double)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§2Location: SkyWars" + " " + "Der Wert \"Z\" ist §4KEINE §r Zahl.");
                        return;
                    }
                    if (!(world instanceof String)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§2Location: SkyWars" + " " + "Der Wert \"world\" ist §4KEIN §r Name.");
                        return;
                    }
                    if (!(yaw instanceof Double)) {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§2Location: SkyWars" + " " + "Der Wert \"yaw\" ist §4KEINE §r Zahl.");
                        return;
                    }
                    if (Bukkit.getWorld((String)world) != null) {
                        p.teleport(new Location(Bukkit.getWorld((String)world), (double)X, (double)Y, (double)Z, (float)Math.floor((double)yaw), 0.0f));
                    }
                    else {
                        p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§2Location: SkyWars" + " " + "§cDiese Welt gibt es nicht!");
                    }
                }
            }
        }
    }
}
