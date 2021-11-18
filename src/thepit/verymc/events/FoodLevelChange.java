package thepit.verymc.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import thepit.verymc.config.ConfigManager;

public class FoodLevelChange implements Listener {
	
	private ConfigManager configManager;
	private boolean active = true;
	private int food_level = 20;
	
	public FoodLevelChange() {
		this.configManager = new ConfigManager();
		this.active = configManager.getEventFoodLevelChangeActive();
		this.food_level = configManager.getEventFoodLevelChangeFoodLevel();
	}
	
	@EventHandler
	public void FoodLevelChange(FoodLevelChangeEvent event) {
		if(event.getEntity() instanceof Player) {
			if(active) {
				Player player = (Player) event.getEntity();
				player.setFoodLevel(food_level);
				event.setCancelled(true);
			}
		}
		
	}

}
