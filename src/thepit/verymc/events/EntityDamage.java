package thepit.verymc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import thepit.verymc.player.PlayerManager;

public class EntityDamage implements Listener {
	
	private PlayerManager playerManager;

	public EntityDamage() {
		this.playerManager = new PlayerManager();
	}
	
	@EventHandler
	public void EntityDamage(EntityDamageEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			//System.out.println(player.getName() + ":" + player.);
		}
	}
	
}
