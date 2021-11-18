package thepit.verymc.events;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;
import thepit.verymc.config.ConfigFileManager;
import thepit.verymc.config.ConfigManager;
import thepit.verymc.player.PlayerManager;

public class PlayerJoin implements Listener {
	
	private ConfigManager configManager;
	private PlayerManager playerManager;
	
	private boolean player_spawn_gamemode_use_permission_no_change = false;
	private String player_spawn_gamemode_permission_no_change = null;
	private GameMode player_spawn_gamemode = GameMode.ADVENTURE;
	private Location player_spawn_location = null;
	
	private boolean use_message = false;
	private String message_join = null;
	
	public PlayerJoin() {
		this.configManager = new ConfigManager();
		this.playerManager = new PlayerManager();
		this.player_spawn_gamemode_use_permission_no_change = configManager.getPlayerSpawnGamemodeUsePermissionNoChange();
		this.player_spawn_gamemode_permission_no_change = configManager.getPlayerSpawnGamemodePermissionNoChange();
		this.player_spawn_gamemode = configManager.getPlayerSpawnGamemode();
		this.player_spawn_location = configManager.getPlayerSpawnLocation();
		this.use_message = false; //configManager.getEventPlayerJoinUseMessage();
		this.message_join = configManager.getEventPlayerJoinMessage();
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event) {
		Player player = (Player) event.getPlayer();
		if(use_message) {
			String message = message_join.replace("{player_name}", player.getName());
			event.setJoinMessage(message);
		} else {
			event.setJoinMessage(null);
		}
		
		playerManager.addPlayer(player);
		
		if(player_spawn_gamemode_use_permission_no_change) {
			if(!player.hasPermission(player_spawn_gamemode_permission_no_change)) {
				player.setGameMode(player_spawn_gamemode);
			}
		} else {
			player.setGameMode(player_spawn_gamemode);
		}
		
		player.teleport(player_spawn_location);
	}

}
