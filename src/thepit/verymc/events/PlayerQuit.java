package thepit.verymc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import thepit.verymc.config.ConfigManager;
import thepit.verymc.player.PlayerManager;

public class PlayerQuit implements Listener {
	
	private PlayerManager playerManager;
	private ConfigManager configManager;
	
	private boolean use_message = false;
	private String message = null;
	
	public PlayerQuit() {
		this.playerManager = new PlayerManager();
		this.configManager = new ConfigManager();
	}
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent event) {
		Player player = (Player) event.getPlayer();
		playerManager.removePlayer(player);
		if(use_message) {
			event.setQuitMessage(null);
		} else {
			event.setQuitMessage(null);
		}

	}
	

}
