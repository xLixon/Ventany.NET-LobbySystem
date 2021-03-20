// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.manageServer;

import de.apis.ChangeName;
import de.apis.itemcreator.ReturnItem;
import de.lobbyplus.items.SaveNick;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class JoinEvent implements Listener {
    String displayNameNavi;
    String displayNameHide;
    String displayNameSilent;
    String displayNameShield;
    String displayNameLobby;
    String displayNameFly;
    String displayNameGM;
    String Fly_ON;
    String Fly_ON_ON;
    String Fly_OFF;
    String Prefix;
    public ArrayList<Player> flyPlayers;
    String displayNameSecret;
    String displayNameInv;
    public static String displayNameNick;
    public TimeUnit lastJoinH;
    public TimeUnit lastJoinM;
    public TimeUnit lastJoinS;
    String lastPlayed;


    ItemStack itemNavi;
    ItemStack itemHide;
    ItemStack itemSilent;
    ItemStack itemInv;
    ItemStack itemNick;
    ItemStack itemLobby;
    ItemStack itemSecret;

    ItemMeta itemmetaNavi;
    ItemMeta itemmetaHide;
    ItemMeta itemmetaSilent;
    ItemMeta itemmetaInv;
    ItemMeta itemmetaNick;
    ItemMeta itemmetaLobby;
    ItemMeta itemmetaSecret;


    @SuppressWarnings("static-access")
    public JoinEvent() {
        this.displayNameNavi = "§cNavigator";
        this.displayNameHide = "§6Spieler verstecken";
        this.displayNameSilent = "§5Silent Hub";
        this.displayNameShield = "§5Schutzschild";
        this.displayNameLobby = "§cLobby";
        this.displayNameFly = "§3Fly";
        this.displayNameGM = "§1Gamemode Switch";
        this.Fly_ON = "§aFlymode aktiviert";
        this.Fly_ON_ON = "§aFlymode aktiviert";
        this.Fly_OFF = "§4Flymode deaktiviert";
        this.Prefix = "§c[§2LobbySystem§c] | §5";
        this.flyPlayers = new ArrayList<Player>();
        this.displayNameSecret = "§9Wow, ein Secret";
        this.displayNameInv = "§eInventar";
        this.displayNameNick = "§6Nick-Tool";
    }


    public void onDisconnect(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        p.getInventory().clear();
        e.setQuitMessage(" ");

    }

    @SuppressWarnings("static-access")
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {

        final Player player = e.getPlayer();
        if (!(player instanceof Player)) {
            return;
        }
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        e.setJoinMessage("");
        player.setFlySpeed(0.2f);

        player.getInventory().setItem(0, ReturnItem.addItem(Material.COMPASS, displayNameNavi));
        player.getInventory().setItem(1, ReturnItem.addItem(Material.BLAZE_ROD, displayNameHide));
        if (player.hasPermission("lobby.perm.silenthub")) {
            player.getInventory().setItem(2, ReturnItem.addItem(Material.TNT, displayNameSilent));
        }
        player.getInventory().setItem(4, ReturnItem.addItem(Material.CHEST, displayNameInv));
        if (player.hasPermission("lobby.perm.nick")) {
            player.getInventory().setItem(6, ReturnItem.addItem(Material.NAME_TAG, displayNameNick));
        }
        player.getInventory().setItem(8, ReturnItem.addItem(Material.NETHER_STAR, displayNameLobby));
        player.getInventory().setItem(9, ReturnItem.addItem(Material.STAINED_GLASS_PANE, displayNameSecret));

        player.setFoodLevel(20);
        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 10, 2));
        player.setGameMode(GameMode.SURVIVAL);
    }

    @EventHandler
    public void onJoinSetGM(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        p.setGameMode(GameMode.SURVIVAL);
    }

    @EventHandler
    public void interact(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == null) {
            return;
        }
        if (p.getItemInHand().getType() == Material.EYE_OF_ENDER) {
            e.setCancelled(true);
        }
        if (e.getItem() == null) {
            return;
        }
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) && e.getItem().getType() == Material.FEATHER) {
            final ItemStack fly = p.getItemInHand();
            final ItemMeta flymeta = fly.getItemMeta();
            if (flymeta.getDisplayName() == this.Fly_ON) {
                flymeta.setDisplayName(this.Fly_OFF);
                p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + this.Fly_OFF);
                this.flyPlayers.remove(p);
                p.setAllowFlight(false);
            } else {
                flymeta.setDisplayName(this.Fly_ON);
                p.sendMessage(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(this.Prefix)))))) + this.Fly_ON);
                this.flyPlayers.add(p);
                p.setAllowFlight(true);
            }
            fly.setItemMeta(flymeta);
        }
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
        if (!(X instanceof Double)) {
            System.out.println("Der Wert \"X\" ist §4KEINE §r Zahl.");
            return;
        }
        if (!(Y instanceof Double)) {
            System.out.println("Der Wert \"Y\" ist §4KEINE §r Zahl.");
            return;
        }
        if (!(Z instanceof Double)) {
            System.out.println("Der Wert \"Z\" ist §4KEINE §r Zahl.");
            return;
        }
        if (!(world instanceof String)) {
            System.out.println("Der Wert \"world\" ist §4KEIN §r Name.");
            return;
        }
        if (!(yaw instanceof Double)) {
            System.out.println("Der Wert \"yaw\" ist §4KEINE §r Zahl.");
            return;
        }
        if (Bukkit.getWorld((String) world) != null) {
            p.teleport(new Location(Bukkit.getWorld((String) world), (double) X, (double) Y, (double) Z, (float) Math.floor((double) yaw), 0.0f));
        } else {
            System.out.println("§cDiese Welt gibt es nicht!");
        }
    }

    @EventHandler
    public void onquit(final PlayerQuitEvent e) {
        e.setQuitMessage("");
    }

    @EventHandler
    public void setName(PlayerJoinEvent e) {
        if (SaveNick.playerNick != null) {
            ChangeName.changeName(SaveNick.playerNick, e.getPlayer());
            e.getPlayer().setPlayerListName(SaveNick.playerNick);
        }
    }
}
