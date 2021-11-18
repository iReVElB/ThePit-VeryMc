package thepit.verymc.events;

import org.bukkit.event.Listener;

import thepit.verymc.player.PlayerManager;

public class EntityDamageByEntity implements Listener {
	
	private PlayerManager playerManager;
	
	public EntityDamageByEntity() {
		this.playerManager = new PlayerManager();
	}

}
