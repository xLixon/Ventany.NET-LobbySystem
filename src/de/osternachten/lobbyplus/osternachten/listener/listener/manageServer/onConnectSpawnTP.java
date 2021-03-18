// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.manageServer;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.Listener;

public class onConnectSpawnTP implements Listener
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
    
    public onConnectSpawnTP() {
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
    public void joinTP(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        final YamlConfiguration spawnPointConfig = YamlConfiguration.loadConfiguration(new File("plugins/LobbySystem/config.yml"));
        final Object X = spawnPointConfig.get("spawn.X");
        final Object Y = spawnPointConfig.get("spawn.Y");
        final Object Z = spawnPointConfig.get("spawn.Z");
        final Object world = spawnPointConfig.get("spawn.WORLD");
        final Object yaw = spawnPointConfig.get("spawn.YAW");
        if (X instanceof Double) {
            if (!(Y instanceof Double)) {
                if (p.isOp()) {
                    p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "Der Wert \"Y\" ist §4KEINE §r Zahl.");
                    return;
                }
                if (!(Z instanceof Double) && p.isOp()) {
                    p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "Der Wert \"Z\" ist §4KEINE §r Zahl.");
                    return;
                }
                if (!(world instanceof String) && p.isOp()) {
                    p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "Der Wert \"world\" ist §4KEIN §r Name.");
                    return;
                }
                if (!(yaw instanceof Double) && p.isOp()) {
                    p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "Der Wert \"yaw\" ist §4KEINE §r Zahl.");
                    return;
                }
            }
            if (Bukkit.getWorld((String)world) != null) {
                p.teleport(new Location(Bukkit.getWorld((String)world), (double)X, (double)Y, (double)Z, (float)Math.floor((double)yaw), 0.0f));
            }
            else if (p.isOp()) {
                p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§cDiese Welt gibt es nicht!");
            }
            return;
        }
        if (p.isOp()) {
            p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "Der Wert \"X\" ist §4KEINE §r Zahl.");
        }
    }
}
