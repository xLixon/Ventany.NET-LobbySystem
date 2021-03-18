// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener.manageServer;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

import de.apis.ChangeName;
import de.lobbyplus.items.SaveNick;

public class JoinEvent implements Listener
{
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
    
    public static void main(final String[] args) {
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
        final ItemStack itemNavi = new ItemStack(Material.COMPASS);
        final ItemMeta itemmetaNavi = itemNavi.getItemMeta();
        itemmetaNavi.setDisplayName(this.displayNameNavi);
        itemNavi.setItemMeta(itemmetaNavi);
        player.getInventory().setItem(0, itemNavi);
        final ItemStack itemHide = new ItemStack(Material.BLAZE_ROD);
        final ItemMeta itemmetaHide = itemHide.getItemMeta();
        itemmetaHide.setDisplayName(this.displayNameHide);
        itemHide.setItemMeta(itemmetaHide);
        player.getInventory().setItem(1, itemHide);
        if (player.hasPermission("lobby.permission.silenthub")) {
            final ItemStack itemSilent = new ItemStack(Material.TNT);
            final ItemMeta itemmetaSilent = itemSilent.getItemMeta();
            itemmetaSilent.setDisplayName(this.displayNameSilent);
            itemSilent.setItemMeta(itemmetaSilent);
            player.getInventory().setItem(2, itemSilent);
        }
        final ItemStack itemInv = new ItemStack(Material.CHEST);
        final ItemMeta itemmetaInv = itemInv.getItemMeta();
        itemmetaInv.setDisplayName(this.displayNameInv);
        itemInv.setItemMeta(itemmetaInv);
        player.getInventory().setItem(4, itemInv);
        if (player.hasPermission("lobby.permission.nick")) {
            final ItemStack itemNick = new ItemStack(Material.NAME_TAG);
            final ItemMeta itemmetaNick = itemNick.getItemMeta();
            itemmetaNick.setDisplayName(this.displayNameNick);
            itemNick.setItemMeta(itemmetaNick);
            player.getInventory().setItem(6, itemNick);
        }
        final ItemStack itemLobby = new ItemStack(Material.NETHER_STAR);
        final ItemMeta itemmetaLobby = itemLobby.getItemMeta();
        itemmetaLobby.setDisplayName(this.displayNameLobby);
        itemLobby.setItemMeta(itemmetaLobby);
        player.getInventory().setItem(8, itemLobby);
        final ItemStack itemSecret = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)8);
        final ItemMeta itemmetaSecret = itemSecret.getItemMeta();
        itemmetaSecret.setDisplayName(this.displayNameSecret);
        itemSecret.setItemMeta(itemmetaSecret);
        player.getInventory().setItem(9, itemSecret);
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
            }
            else {
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
        if (Bukkit.getWorld((String)world) != null) {
            p.teleport(new Location(Bukkit.getWorld((String)world), (double)X, (double)Y, (double)Z, (float)Math.floor((double)yaw), 0.0f));
        }
        else {
            System.out.println("§cDiese Welt gibt es nicht!");
        }
    }
    
    @EventHandler
    public void onquit(final PlayerQuitEvent e) {
        e.setQuitMessage("");
    }
    
    @EventHandler
    public void setName(PlayerJoinEvent e) {
    	if(SaveNick.playerNick != null) {
    		ChangeName.changeName(SaveNick.playerNick, e.getPlayer());
    		e.getPlayer().setPlayerListName(SaveNick.playerNick);
    	}
    }
}
