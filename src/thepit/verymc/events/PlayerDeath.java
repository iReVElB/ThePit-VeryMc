package thepit.verymc.events;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import thepit.verymc.player.PlayerInfo;
import thepit.verymc.player.PlayerManager;
import thepit.verymc.main;
import thepit.verymc.config.ConfigManager;

public class PlayerDeath implements Listener {
	
	private PlayerManager playerManager;
	private ConfigManager configManager;
	private main main;
	
	private boolean auto_respawn = true;
	private boolean use_message = false;
	private String message = null;
	
	public PlayerDeath(main main) {
		this.playerManager = new PlayerManager();
		this.configManager = new ConfigManager();
		this.main = main;
		this.auto_respawn = configManager.getEventPlayerDeathAutoRespawn();
		this.use_message = configManager.getEventPlayerDeathUseMessage();
		this.message = configManager.getEventPlayerDeathMessage();
	}
	
	@EventHandler
	public void PlayerDeath(PlayerDeathEvent event) {
		Player player = (Player) event.getEntity();
		if(auto_respawn) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(main, () -> player.spigot().respawn(), 2);
		}
		if(use_message) {
			event.setDeathMessage(null);
		} else {
			event.setDeathMessage(null);
		}

		PlayerInfo player_info = playerManager.getPlayerInfo(player);
		if(player_info != null) {
			player_info.death++;
		}
		playerManager.PlayerListConsole();
		
		
	}

}
