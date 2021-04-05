// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys;

import de.apis.itemcreator.ReturnItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InvNaviCreate implements Listener {
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
    String displayNameVanilla;

    public InvNaviCreate() {
        this.inv = Bukkit.createInventory((InventoryHolder) null, 54);
        this.nameNavigator = "§cNavigator";
        this.Prefix = "§c[§2LobbySystem§c] | §5";
        this.displayNameSpawn = "§6Spawn";
        this.displayNameSkyWarsItem = "§aSkyWars";
        this.displayNameBedWarsItem = "§cBed§rWars";
        this.displayName1v1Item = "§d1v1";
        this.displayNameCBItem = "§5CityBuild";
        this.displayNameCoresItem = "§b§lCores";
        this.displayNameSpeedUHCItem = "§e§lSpeedUHC";
        this.displayNameEGItem = "§5§lEnderGames";
        this.displayNameTTTItem = "§4§lTTT";
        this.displayNameJARItem = "§c§lJumpAndRun";
        this.displayNameGunGameItem = "§3§lGunGame";
        this.displayNameFFAItem = "§d§lFFA";
        this.displayNameGame1v1Item = "§1§lGame 1vs1";
        this.displayNameKit1v1Item = "§1§lKit 1vs1";
        this.displayNameSGItem = "§a§lSurvivalGames";
        this.displayNameCommunity = "§5§lCommunity";
        this.displayNameLounge = "§6§lLounge";
        this.displayNameVanilla = "§7[§aVanilla§7]§c[1.16.4]";
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() == null) {
                return;
            }
            if (e.getItem().getType() == Material.COMPASS && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.nameNavigator)) {
                final Inventory inv = Bukkit.createInventory((InventoryHolder) e.getPlayer(), InventoryType.HOPPER, this.nameNavigator);

                inv.setItem(0, ReturnItem.addItem(Material.DIAMOND_PICKAXE, displayNameVanilla));
                inv.setItem(2, ReturnItem.addItem(Material.MAGMA_CREAM, displayNameSpawn));
                inv.setItem(4, ReturnItem.addItem(Material.BED, displayNameBedWarsItem));

                e.getPlayer().openInventory(inv);
            }
        }
    }
}
