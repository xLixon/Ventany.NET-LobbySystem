// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.minecraft.server.v1_8_R3.Block;

public class InvInventoryCreate implements Listener
{
    Inventory inv;
    String nameNavigator;
    String nameHide;
    String nameLobby;
    String Prefix;
    public String nameHideSee;
    public String nameHideVIP;
    public String nameHideNone;
    String displayNameSpawn;
    String displayNameSkyWarsItem;
    String displayNameBedWarsItem;
    String displayName1v1Item;
    String displayNameCBItem;
    String displayNameODV;
    String displayNameLobby1;
    String displayNameLobby2;
    String displayNameLobby3;
    String nameInventory;
    String invBoots;
    String invHats;
    String invSpecial;
    
    public InvInventoryCreate() {
        this.inv = Bukkit.createInventory((InventoryHolder)null, 54);
        this.nameNavigator = "§cNavigator";
        this.nameHide = "§6Spieler verstecken";
        this.nameLobby = "§cLobby";
        this.Prefix = "§c[§2LobbySystem§c] | §5";
        this.nameHideSee = "§aAlle Spieler sehen";
        this.nameHideVIP = "§5Nur VIP's sehen";
        this.nameHideNone = "§4Keine Spieler sehen";
        this.displayNameSpawn = "§6Spawn";
        this.displayNameSkyWarsItem = "§aSkyWars";
        this.displayNameBedWarsItem = "§cBed§rWars";
        this.displayName1v1Item = "§d1v1";
        this.displayNameCBItem = "§5CityBuild";
        this.displayNameODV = "§2OneDayVaro";
        this.displayNameLobby1 = "§bLobby 1";
        this.displayNameLobby2 = "§bLobby 2";
        this.displayNameLobby3 = "§bLobby 3";
        this.nameInventory = "§eInventar";
        this.invBoots = "§cBoots";
        this.invHats = "§cHats";
        this.invSpecial = "§cSpecial Items";
    }
    
    @EventHandler
    public void onInteract3(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() == null) {
                return;
            }
            if (e.getItem().getType() == Material.CHEST && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.nameInventory)) {
            	
                final Inventory inv = Bukkit.createInventory((InventoryHolder)e.getPlayer(), 27, this.nameInventory);
                final ItemStack invBoots = new ItemStack(Material.GOLD_BOOTS);
                final ItemMeta itmemmetainvBoots = invBoots.getItemMeta();
                itmemmetainvBoots.setDisplayName(this.invBoots);
                invBoots.setItemMeta(itmemmetainvBoots);
                
                final ItemStack invHats = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                final SkullMeta itemmetaInvHats = (SkullMeta)invHats.getItemMeta();
                itemmetaInvHats.setOwner(p.getName());
                itemmetaInvHats.setDisplayName(this.invHats);
                invHats.setItemMeta((ItemMeta)itemmetaInvHats);
                final ItemStack invSpecial = new ItemStack(Material.DRAGON_EGG);
                final ItemMeta itemmetainvSpecial = invSpecial.getItemMeta();
                itemmetainvSpecial.setDisplayName(this.invSpecial);
                invSpecial.setItemMeta(itemmetainvSpecial);
                inv.setItem(0, invBoots);
                inv.setItem(1, invHats);
                inv.setItem(2, invSpecial);
                e.getPlayer().openInventory(inv);
            }
        }
    }
    
    @EventHandler
    public void onPlayer(BlockPlaceEvent e) {
    	Block b = (Block) e.getBlock();
    	
    	if(b.getMaterial().equals(Material.CHEST)) {
    		System.out.println("Player tryed to place CHEST");
    		e.setCancelled(true);
    	}
    }
}
