
package de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys;

import de.apis.itemcreator.ReturnItem;
import de.osternachten.lobbyplus.osternachten.listener.listener.LobbyPlus;
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
import org.bukkit.plugin.Plugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class InvLobbyCreate implements Listener {
    public static LobbyPlus instance;
    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_BLACK = "\u001b[30m";
    public static final String ANSI_RED = "\u001b[31m";
    public static final String RED_BRIGHT = "\u001b[0;91m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_PURPLE = "\u001b[35m";
    public static final String ANSI_CYAN = "\u001b[36m";
    public static final String ANSI_WHITE = "\u001b[37m";
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
    LobbyPlus pl;

    public InvLobbyCreate() {
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
    }

    @EventHandler
    public void onInteract3(final PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() == null) {
                return;
            }
            if (e.getItem().getType() == Material.NETHER_STAR && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.nameLobby)) {
                final Inventory inv = Bukkit.createInventory((InventoryHolder) e.getPlayer(), 27, this.nameLobby);


                inv.setItem(0, ReturnItem.addItem(Material.NETHER_STAR, displayNameLobby1));
                inv.setItem(1, ReturnItem.addItem(Material.NETHER_STAR, displayNameLobby2));
                e.getPlayer().openInventory(inv);
            }
        }
    }

    @EventHandler
    public void lobbyConnectClick1(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.isRightClick() || e.isLeftClick()) {
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if ((e.isRightClick() || e.isLeftClick()) && e.getInventory().contains(Material.NETHER_STAR) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.displayNameLobby1)) {
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                    return;
                }
                if (!p.getServer().getName().equalsIgnoreCase("Lobby-1")) {
                    p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§cEntweder nutzt du kein BungeeCord Netzwerk oder die Namen sind falsch eingestellt.");
                    p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§cFolgende Namen sind erlaubt: lobby1 ; lobby2");
                    p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§c\u00c4ndere diese Namen in deiner BungeeCord Config bei deinen Default Fallback Servern.");
                    return;
                }
                this.connectPlayerToServer(p, "Lobby-1");
                System.out.println("\u001b[31m[LobbySystem] Der Spieler " + e.getWhoClicked().getName() + " wurde auf den Server " + e.getWhoClicked().getServer().getName() + "gesendet." + "\u001b[0m");
            }
        }
    }

    public void connectPlayerToServer(final Player player, final String server) {
        try {
            final ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            final DataOutputStream dataOut = new DataOutputStream(byteOut);
            dataOut.writeUTF("Connect");
            dataOut.writeUTF(server);
            player.sendPluginMessage((Plugin) LobbyPlus.getInstance(), "bungeecord:main", byteOut.toByteArray());
            Bukkit.getConsoleSender().sendMessage("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void lobbyConnectClick2(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
            return;
        }
        if ((e.isRightClick() || e.isLeftClick()) && e.getInventory().contains(Material.NETHER_STAR) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(this.displayNameLobby2)) {
            if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals((Object) Material.AIR)) {
                return;
            }
            if (!p.getServer().getName().equalsIgnoreCase("Lobby-2")) {
                p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§cEntweder nutzt du kein BungeeCord Netzwerk oder die Namen sind falsch eingestellt.");
                p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§cFolgende Namen sind erlaubt: lobby1 ; lobby2");
                p.sendMessage(String.valueOf(String.valueOf(this.Prefix)) + "§c\u00c4ndere diese Namen in deiner BungeeCord Config bei deinen Default Fallback Servern.");
                return;
            }
            p.sendMessage(String.valueOf(String.valueOf(String.valueOf(this.Prefix))) + "§8Du bist jetzt mit dem Server §c" + p.getServer().getName() + "§8verbunden.");
            System.out.println("\u001b[31m[LobbySystem] Der Spieler " + e.getWhoClicked().getName() + " wurde auf den Server " + e.getWhoClicked().getServer().getName() + "gesendet." + "\u001b[0m");


            this.connectPlayerToServer(p, "Lobby-2");
        }
    }
}
