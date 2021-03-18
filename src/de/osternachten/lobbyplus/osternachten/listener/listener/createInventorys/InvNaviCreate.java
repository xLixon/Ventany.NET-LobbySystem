// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvNaviCreate implements Listener
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
                final Inventory inv = Bukkit.createInventory((InventoryHolder)e.getPlayer(), InventoryType.HOPPER, this.nameNavigator);
                
//                final ItemStack itemCommunity = new ItemStack(Material.DIAMOND_BLOCK);
//                final ItemMeta itemmetaCommunity = itemCommunity.getItemMeta();
//                itemmetaCommunity.setDisplayName(this.displayNameCommunity);
//                itemCommunity.setItemMeta(itemmetaCommunity);
                
                final ItemStack itemSpawn = new ItemStack(Material.MAGMA_CREAM);
                final ItemMeta itemmetaSpawn = itemSpawn.getItemMeta();
                itemmetaSpawn.setDisplayName(this.displayNameSpawn);
                itemSpawn.setItemMeta(itemmetaSpawn);
                
//                final ItemStack itemLounge = new ItemStack(Material.GOLDEN_CARROT);
//                final ItemMeta itemmetaLounge = itemLounge.getItemMeta();
//                itemmetaLounge.setDisplayName(this.displayNameLounge);
//                itemLounge.setItemMeta(itemmetaLounge);
                
                final ItemStack itemVanilla = new ItemStack(Material.DIAMOND_PICKAXE);
                final ItemMeta itemmetaVanilla = itemVanilla.getItemMeta();
                itemmetaVanilla.setDisplayName(this.displayNameVanilla);
                itemVanilla.setItemMeta(itemmetaVanilla);
                
                final ItemStack itemBedWars = new ItemStack(Material.BED);
                final ItemMeta itemmetaBedWars = itemBedWars.getItemMeta();
                itemmetaBedWars.setDisplayName(this.displayNameBedWarsItem);
                itemBedWars.setItemMeta(itemmetaBedWars);
                
//                final ItemStack itemCores = new ItemStack(Material.BEACON);
//                final ItemMeta itemmetaCores = itemCores.getItemMeta();
//                itemmetaCores.setDisplayName(this.displayNameCoresItem);
//                itemCores.setItemMeta(itemmetaCores);
//                
//                final ItemStack itemCB = new ItemStack(Material.WORKBENCH);
//                final ItemMeta itemmetaCB = itemCB.getItemMeta();
//                itemmetaCB.setDisplayName(this.displayNameCBItem);
//                itemCB.setItemMeta(itemmetaCB);
//                
//                final ItemStack itemJAR = new ItemStack(Material.DIAMOND_BOOTS);
//                final ItemMeta itmemetaJAR = itemJAR.getItemMeta();
//                itmemetaJAR.setDisplayName(this.displayNameJARItem);
//                itemJAR.setItemMeta(itmemetaJAR);
//                
//                final ItemStack itemTTT = new ItemStack(Material.STICK);
//                final ItemMeta itemmetaTTT = itemTTT.getItemMeta();
//                itemmetaTTT.setDisplayName(this.displayNameTTTItem);
//                itemTTT.setItemMeta(itemmetaTTT);
//                
//                final ItemStack itemSUHC = new ItemStack(Material.GOLDEN_APPLE);
//                final ItemMeta itemmetaSUHC = itemSUHC.getItemMeta();
//                itemmetaSUHC.setDisplayName(this.displayNameSpeedUHCItem);
//                itemSUHC.setItemMeta(itemmetaSUHC);
//                
//                final ItemStack itemEG = new ItemStack(Material.EYE_OF_ENDER);
//                final ItemMeta itemmetaEG = itemEG.getItemMeta();
//                itemmetaEG.setDisplayName(this.displayNameEGItem);
//                itemEG.setItemMeta(itemmetaEG);
//                
//                final ItemStack itemGG = new ItemStack(Material.WOOD_AXE);
//                final ItemMeta itemmetaGG = itemGG.getItemMeta();
//                itemmetaGG.setDisplayName(this.displayNameGunGameItem);
//                itemGG.setItemMeta(itemmetaGG);
//                
//                final ItemStack itemFFA = new ItemStack(Material.DIAMOND_CHESTPLATE);
//                final ItemMeta itemmetaFFA = itemFFA.getItemMeta();
//                itemmetaFFA.setDisplayName(this.displayNameFFAItem);
//                itemFFA.setItemMeta(itemmetaFFA);
//                
//                final ItemStack itemG1v1 = new ItemStack(Material.GOLD_HELMET);
//                final ItemMeta itemmetaG1v1 = itemG1v1.getItemMeta();
//                itemmetaG1v1.setDisplayName(this.displayNameGame1v1Item);
//                itemG1v1.setItemMeta(itemmetaG1v1);
//                
//                final ItemStack item1v1 = new ItemStack(Material.DIAMOND_SWORD);
//                final ItemMeta itemmeta1v1 = item1v1.getItemMeta();
//                itemmeta1v1.setDisplayName(this.displayNameKit1v1Item);
//                item1v1.setItemMeta(itemmeta1v1);
//                
//                final ItemStack itemSG = new ItemStack(Material.IRON_SWORD);
//                final ItemMeta itemmetaSG = itemSG.getItemMeta();
//                itemmetaSG.setDisplayName(this.displayNameSGItem);
//                itemSG.setItemMeta(itemmetaSG);
                
                inv.setItem(0, itemVanilla);
                inv.setItem(2, itemSpawn);
                inv.setItem(4, itemBedWars);
                
//                inv.setItem(6, itemLounge);
//                inv.setItem(10, itemSkyWars);
//                inv.setItem(12, itemCores);
//                inv.setItem(13, itemCB);
//                inv.setItem(14, itemJAR);
//                inv.setItem(15, itemTTT);
//                inv.setItem(16, itemSUHC);
//                inv.setItem(19, itemEG);
//                inv.setItem(20, itemGG);
//                inv.setItem(21, itemFFA);
//                inv.setItem(23, itemG1v1);
//                inv.setItem(24, item1v1);
//                inv.setItem(25, itemSG);
                e.getPlayer().openInventory(inv);
            }
        }
    }
}
