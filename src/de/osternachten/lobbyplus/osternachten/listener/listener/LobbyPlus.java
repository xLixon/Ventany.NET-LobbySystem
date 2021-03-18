// 
// Decompiled by Procyon v0.5.36
// 

package de.osternachten.lobbyplus.osternachten.listener.listener;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.leandergamesyt.commands.BuildMode;
import de.leandergamesyt.commands.CMD_Heal;
import de.leandergamesyt.commands.GM1;
import de.leandergamesyt.commands.Nick;
import de.leandergamesyt.commands.OwnPerms;
import de.leandergamesyt.commands.PlayerPrefix;
import de.leandergamesyt.commands.PrivatMessagesMSG;
import de.leandergamesyt.commands.SetWarp;
import de.leandergamesyt.commands.TestMSG;
import de.leandergamesyt.commands.Wartungsmodus;
import de.lobbyplus.items.SaveNick;
import de.osternachten.listener.listener.navigator.Teleport1v1;
import de.osternachten.listener.listener.navigator.TeleportBedWars;
import de.osternachten.listener.listener.navigator.TeleportCityBuild;
import de.osternachten.listener.listener.navigator.TeleportCommunity;
import de.osternachten.listener.listener.navigator.TeleportCores;
import de.osternachten.listener.listener.navigator.TeleportEndergames;
import de.osternachten.listener.listener.navigator.TeleportFFA;
import de.osternachten.listener.listener.navigator.TeleportG1v1;
import de.osternachten.listener.listener.navigator.TeleportGunGame;
import de.osternachten.listener.listener.navigator.TeleportJumpAndRun;
import de.osternachten.listener.listener.navigator.TeleportLounge;
import de.osternachten.listener.listener.navigator.TeleportSG;
import de.osternachten.listener.listener.navigator.TeleportSkyWars;
import de.osternachten.listener.listener.navigator.TeleportSpawn;
import de.osternachten.listener.listener.navigator.TeleportSpeedUHC;
import de.osternachten.listener.listener.navigator.TeleportTTT;
import de.osternachten.listener.listener.navigator.TeleportVanilla;
import de.osternachten.lobbyplus.osternachten.listener.listener.chat.ChatColorRed;
import de.osternachten.lobbyplus.osternachten.listener.listener.chat.ChatManager;
import de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys.InvHatsCreate;
import de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys.InvHideCreate;
import de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys.InvInventoryCreate;
import de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys.InvLobbyCreate;
import de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys.InvNaviCreate;
import de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys.InvSpecialCreate;
import de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys.InventoryCreate;
import de.osternachten.lobbyplus.osternachten.listener.listener.createInventorys.hider;
import de.osternachten.lobbyplus.osternachten.listener.listener.extras.DoubleJump;
import de.osternachten.lobbyplus.osternachten.listener.listener.extras.SecretListener;
import de.osternachten.lobbyplus.osternachten.listener.listener.manageServer.JoinEvent;
import de.osternachten.lobbyplus.osternachten.listener.listener.manageServer.KickAll;
import de.osternachten.lobbyplus.osternachten.listener.listener.manageServer.LeaveEvent;
import de.osternachten.lobbyplus.osternachten.listener.listener.manageServer.WorldProtector;
import de.osternachten.lobbyplus.osternachten.listener.listener.manageServer.onConnectSpawnTP;
import de.osternachten.lobbyplus.osternachten.listener.listener.opClass.op;
import de.osternachten.lobbyplus.osternachten.listener.listener.playerList.Prefix;
import de.osternachten.lobbyplus.osternachten.listener.listener.playerList.SecondPrefixes;
import de.osternachten.lobbyplus.osternachten.listener.listener.playerList.Tab;
import de.xlixon.boots.ClearBoots;
import de.xlixon.boots.FireBoots;
import de.xlixon.boots.InvBootsCreate;
import de.xlixon.boots.LavaBoots;
import de.xlixon.boots.LoveBoots;
import de.xlixon.boots.WaterBoots;
import de.xlixon.commands.CleanChat;
import de.xlixxn.hats.AviveHat;
import de.xlixxn.hats.CloseInv;
import de.xlixxn.hats.CreateHatsInventory;
import de.xlixxn.hats.GommeHat;
import de.xlixxn.hats.LPMitKevHat;
import de.xlixxn.hats.Lumpi;
import de.xlixxn.hats.MinimicheckerHat;
import de.xlixxn.hats.RewiHat;
import de.xlixxn.hats.TricketyHat;
import de.xlixxn.hats.xLixonHat;

public final class LobbyPlus extends JavaPlugin {
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
	public TimeUnit lastJoinH;
	public TimeUnit lastJoinM;
	public TimeUnit lastJoinS;
	public final ChatManager chatManager;
	
	public static final String noPermsError = "§7[§e!§7]§4Du hast nicht genügend Rechte für diesen Befehl!";

	public LobbyPlus() {
		this.chatManager = new ChatManager();
	}

	public void onEnable() {
		SecondPrefixes.init();
		LobbyPlus.instance = this;
		System.out.println(
				"\u001b[0;91m[LobbySystem] \u001b[31mPlugin wurde geladen: \u001b[32mLobbyPlus | LobbySystem\u001b[33m by xLixon\u001b[0m\u001b[0m");
		this.onEventsRegister();
		this.loadConfig();
		this.onConf();
		Bukkit.getMessenger().registerOutgoingPluginChannel((Plugin) this, "BungeeCord");
		this.getCommand("setwarp").setExecutor((CommandExecutor) new SetWarp());
		this.getCommand("heal").setExecutor((CommandExecutor) new CMD_Heal());
		this.getCommand("gm").setExecutor((CommandExecutor) new GM1());
		this.getCommand("kickall").setExecutor((CommandExecutor) new KickAll());
		this.getCommand("perms").setExecutor((CommandExecutor) new OwnPerms());
		this.getCommand("prefix").setExecutor((CommandExecutor) new PlayerPrefix());
		this.getCommand("cc").setExecutor(new CleanChat());
		this.getCommand("cleanchat").setExecutor(new CleanChat());
		this.getCommand("wartung").setExecutor(new Wartungsmodus());
		this.getCommand("nick").setExecutor(new Nick());
		this.getCommand("build").setExecutor(new BuildMode());
		this.getCommand("test").setExecutor(new TestMSG());
		this.getCommand("msg").setExecutor(new PrivatMessagesMSG());
		
	}

	public void onDisconnect(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		p.getInventory().clear();
		e.setQuitMessage(" ");
		
	}

	public void onJoin(final PlayerJoinEvent e) {
		@SuppressWarnings("unused")
		final Player p = e.getPlayer();
		
	}

	public void onDisable() {
	}

	public static LobbyPlus getInstance() {
		return LobbyPlus.instance;
	}

	public void loadConfig() {
		this.getConfig().options().header("Spawn");
		this.getConfig().options().copyDefaults();
		this.saveConfig();
	}

	public void onConf() {
		this.getConfig().addDefault("plugins/hi.yml", (Object) this);
		this.saveConfig();
	}

	private void onEventsRegister() {
		final PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents((Listener) new CMD_Heal(), (Plugin) this);
		pm.registerEvents((Listener) new SetWarp(), (Plugin) this);
		pm.registerEvents((Listener) new KickAll(), (Plugin) this);
		pm.registerEvents((Listener) new OwnPerms(), (Plugin) this);
		pm.registerEvents((Listener) new InventoryCreate(), (Plugin) this);
		pm.registerEvents((Listener) new JoinEvent(), (Plugin) this);
		pm.registerEvents((Listener) new op(), (Plugin) this);
		pm.registerEvents((Listener) new onConnectSpawnTP(), (Plugin) this);
		pm.registerEvents((Listener) new InvHideCreate(), (Plugin) this);
		pm.registerEvents((Listener) new InvLobbyCreate(), (Plugin) this);
		pm.registerEvents((Listener) new InvNaviCreate(), (Plugin) this);
		pm.registerEvents((Listener) new InvInventoryCreate(), (Plugin) this);
		pm.registerEvents((Listener) new de.lobbyplus.items.Spawn(), (Plugin) this);
		pm.registerEvents((Listener) new de.lobbyplus.items.SkyWars(), (Plugin) this);
		pm.registerEvents((Listener) new de.lobbyplus.items.SilentHub(), (Plugin) this);
		pm.registerEvents((Listener) new de.lobbyplus.items.Shield(), (Plugin) this);
		pm.registerEvents((Listener) new WorldProtector(), (Plugin) this);
		pm.registerEvents((Listener) new hider(), (Plugin) this);
		pm.registerEvents((Listener) new SecretListener(), (Plugin) this);
		pm.registerEvents((Listener) new Tab(null), (Plugin) this);
		pm.registerEvents((Listener) new LeaveEvent(), (Plugin) this);
		pm.registerEvents((Listener) new CreateHatsInventory(), (Plugin) this);
		pm.registerEvents((Listener) new LeaveEvent(), (Plugin) this);
		pm.registerEvents((Listener) new ChatColorRed(), (Plugin) this);
		pm.registerEvents((Listener) new SecondPrefixes(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportSpawn(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportSkyWars(), (Plugin) this);
		pm.registerEvents((Listener) new Teleport1v1(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportBedWars(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportCityBuild(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportCommunity(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportCores(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportEndergames(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportFFA(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportG1v1(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportGunGame(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportJumpAndRun(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportSG(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportSpeedUHC(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportTTT(), (Plugin) this);
		pm.registerEvents((Listener) new TeleportLounge(), (Plugin) this);
		pm.registerEvents((Listener) new InvHatsCreate(), (Plugin) this);

		pm.registerEvents((Listener) new InvBootsCreate(), (Plugin) this);
		pm.registerEvents((Listener) new InvSpecialCreate(), (Plugin) this);
		pm.registerEvents((Listener) new FireBoots(), (Plugin) this);
		pm.registerEvents((Listener) new WaterBoots(), (Plugin) this);
		pm.registerEvents((Listener) new LavaBoots(), (Plugin) this);
		pm.registerEvents((Listener) new LoveBoots(), (Plugin) this);
		pm.registerEvents((Listener) new ClearBoots(), (Plugin) this);
		pm.registerEvents((Listener) new GommeHat(), (Plugin) this);
		pm.registerEvents((Listener) new RewiHat(), (Plugin) this);
		pm.registerEvents((Listener) new AviveHat(), (Plugin) this);
		pm.registerEvents((Listener) new LPMitKevHat(), (Plugin) this);
		pm.registerEvents((Listener) new Lumpi(), (Plugin) this);
		pm.registerEvents((Listener) new MinimicheckerHat(), (Plugin) this);
		pm.registerEvents((Listener) new CloseInv(), (Plugin) this);
		pm.registerEvents((Listener) new InvSpecialCreate(), (Plugin) this);
		pm.registerEvents((Listener) new Prefix(), (Plugin) this);
		pm.registerEvents(new DoubleJump(), this);
		pm.registerEvents(new SaveNick(), this);
		pm.registerEvents(new xLixonHat(), this);
		pm.registerEvents(new TricketyHat(), this);
		pm.registerEvents(new TeleportVanilla(), this);
	}
}
