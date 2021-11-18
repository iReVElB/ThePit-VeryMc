package thepit.verymc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import thepit.verymc.config.ConfigManager;

public class PlayerRespawn implements Listener {
	
	private ConfigManager configManager;
	
	public PlayerRespawn() {
		this.configManager = new ConfigManager();
	}
	
	@EventHandler
	public void PlayerRespawn(PlayerRespawnEvent event) {
		Player player = (Player) event.getPlayer();
		event.setRespawnLocation(configManager.getPlayerSpawnLocation());
	}

}
