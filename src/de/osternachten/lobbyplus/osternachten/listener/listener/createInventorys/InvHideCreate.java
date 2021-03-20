// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InvHideCreate implements Listener {
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
    String closeInv;

    public InvHideCreate() {
        this.inv = Bukkit.createInventory((InventoryHolder) null, 54);
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
        this.closeInv = "§cInventar schlie\u00dfen";
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final ArrayList<String> loreSEE = new ArrayList<String>();
        loreSEE.add(ChatColor.RESET + "§2Hier siehst du alle Spieler auf deiner Lobby");
        final ArrayList<String> loreVIP = new ArrayList<String>();
        loreVIP.add(ChatColor.RESET + "§dDu magst nur deine Freunde sehen?");
        loreVIP.add(ChatColor.RESET + "§dDann aktiviere diese Funtkion und nur bestimmte Leute werden von dir gesehen!!");
        final ArrayList<String> loreHIDE = new ArrayList<String>();
        loreHIDE.add(ChatColor.RESET + "§cVerstecke alle nervenden Spieler");
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() == null) {
                return;
            }
            if (e.getItem().getType() == Material.BLAZE_ROD && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.nameHide)) {

                final Inventory inv = Bukkit.createInventory((InventoryHolder) e.getPlayer(), 27, this.nameHide);
                final ItemStack itemSee = new ItemStack(Material.INK_SACK, 1, (short) 10);
                final ItemMeta itemmetaSee = itemSee.getItemMeta();
                itemmetaSee.setDisplayName(this.nameHideSee);
                itemmetaSee.setLore((List) loreSEE);
                itemSee.setItemMeta(itemmetaSee);
                final ItemStack itemVIP = new ItemStack(Material.INK_SACK, 1, (short) 5);
                final ItemMeta itemmetaVIP = itemVIP.getItemMeta();
                itemmetaVIP.setDisplayName(this.nameHideVIP);
                itemmetaVIP.setLore((List) loreVIP);
                itemVIP.setItemMeta(itemmetaVIP);
                final ItemStack itemNone = new ItemStack(Material.INK_SACK, 1, (short) 1);
                final ItemMeta itemmetaNone = itemNone.getItemMeta();
                itemmetaNone.setDisplayName(this.nameHideNone);
                itemmetaNone.setLore((List) loreHIDE);
                itemNone.setItemMeta(itemmetaNone);
                final ItemStack closeInv = new ItemStack(Material.BARRIER);
                final ItemMeta itemmeetaCloseInv = closeInv.getItemMeta();
                itemmeetaCloseInv.setDisplayName(this.closeInv);
                closeInv.setItemMeta(itemmeetaCloseInv);
                inv.setItem(10, itemSee);
                inv.setItem(13, itemVIP);
                inv.setItem(16, itemNone);
                inv.setItem(0, closeInv);
                e.getPlayer().openInventory(inv);
            }
        }
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
    private void closeInv(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(this.nameHide)) {
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR) || !e.getCurrentItem().hasItemMeta() || !e.getCurrentItem().getItemMeta().hasDisplayName()) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cInventar schlie\u00dfen")) {
                p.closeInventory();
            }
        }
    }

    @EventHandler
    private void onClickSee(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(this.nameHide)) {
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR) || !e.getCurrentItem().hasItemMeta() || !e.getCurrentItem().getItemMeta().hasDisplayName()) {
                return;
            }
            if (!e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAlle Spieler sehen")) {
                return;
            }
            this.showPlayer(p);
            p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + " §aEs werden jetzt ALLE Spieler angezeigt.");
            p.closeInventory();
        }
    }

    @EventHandler
    private void onClickVIP(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(this.nameHide)) {
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR) || !e.getCurrentItem().hasItemMeta() || !e.getCurrentItem().getItemMeta().hasDisplayName()) {
                return;
            }
            if (!e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.nameHideVIP)) {
                return;
            }
            if (p.hasPermission("lobby.owner") || p.hasPermission("lobby.teamleitung") || p.hasPermission("lobby.developer") || p.hasPermission("lobby.moderator") || p.hasPermission("lobby.supporter") || p.hasPermission("lobby.builder") || p.hasPermission("lobby.YouTuber") || p.hasPermission("lobby.premiplus")) {
                this.hidePlayer(p);
            }
            this.showVIP(p);
            p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + " §5Es werden jetzt nur VIP Spieler angezeigt.");
            p.closeInventory();
        }
    }

    @EventHandler
    private void onClickNone(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(this.nameHide)) {
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR) || !e.getCurrentItem().hasItemMeta() || !e.getCurrentItem().getItemMeta().hasDisplayName()) {
                return;
            }
            if (!e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.nameHideNone)) {
                return;
            }
            this.hidePlayer(p);
            p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + " §4Es werden jetzt KEINE Spieler angezeigt.");
            p.closeInventory();
        }
    }
}
