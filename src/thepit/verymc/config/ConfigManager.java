package thepit.verymc.config;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
	
	private ConfigFileManager configFileManager;
	private FileConfiguration config;
	
	public ConfigManager(){
		this.configFileManager = new ConfigFileManager();
		config = configFileManager.getFileConfiguration();
	}
	
	public Location getPlayerSpawnLocation() {
		World world = getPlayerSpawnWorld();
		Location location = new Location(world, getPlayerSpawnLocationX(), getPlayerSpawnLocationY(), getPlayerSpawnLocationZ(), getPlayerSpawnLocationYaw(), getPlayerSpawnLocationPitch());
		return location;
	}
	
	public World getPlayerSpawnWorld() {
		return Bukkit.getWorld(config.getString("player_spawn.world_name"));
	}
	
	public double getPlayerSpawnLocationX() {
		return config.getDouble("player_spawn.location.x");
	}
	
	public double getPlayerSpawnLocationY() {
		return config.getDouble("player_spawn.location.y");
	}
	
	public Double getPlayerSpawnLocationZ() {
		return config.getDouble("player_spawn.location.z");
	}
	
	public Float getPlayerSpawnLocationYaw() {
		return (float) config.getDouble("player_spawn.location.yaw");
	}
	
	public Float getPlayerSpawnLocationPitch() {
		return (float) config.getDouble("player_spawn.location.ptich");
	}
	
	public GameMode getPlayerSpawnGamemode() {
		int gamemode = config.getInt("player_spawn.gamemode.gamemode");
		if(gamemode >= 0 && gamemode <= 3) {
			return GameMode.getByValue(gamemode);
		} else {
			return GameMode.ADVENTURE;
		}
	}
	
	public boolean getPlayerSpawnGamemodeUsePermissionNoChange() {
		return config.getBoolean("player_spawn.gamemode.use_permission_no_change");
	}
	
	public String getPlayerSpawnGamemodePermissionNoChange() {
		return config.getString("player_spawn.gamemode.permission_no_change");
	}
	
	public Boolean getEventPlayerJoinUseMessage() {
		return config.getBoolean("events.player_join.use_message");
	}
	
	public String getEventPlayerJoinMessage() {
		return config.getString("events.player_join.message");
	}
	
	public boolean getEventFoodLevelChangeActive() {
		return config.getBoolean("events.food_level_change.active");
	}
	
	public int getEventFoodLevelChangeFoodLevel() {
		return config.getInt("events.food_level_change.food_level");
	}
	
	public Boolean getEventPlayerQuitUseMessage() {
		return config.getBoolean("events.player_quit.use_message");
	}
	
	public String getEventPlayerQuitMessage() {
		return config.getString("events.player_quit.message");
	}
	
	public boolean getEventPlayerDeathAutoRespawn() {
		return config.getBoolean("events.player_death.auto_respawn");
	}
	
	public Boolean getEventPlayerDeathUseMessage() {
		return config.getBoolean("events.player_death.use_message");
	}
	
	public String getEventPlayerDeathMessage() {
		return config.getString("events.player_death.message");
	}

}
