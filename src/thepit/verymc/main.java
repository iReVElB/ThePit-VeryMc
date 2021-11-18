package thepit.verymc;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import thepit.verymc.commands.ThePit;
import thepit.verymc.config.ConfigFileManager;
import thepit.verymc.events.EntityDamage;
import thepit.verymc.events.EntityDamageByEntity;
import thepit.verymc.events.FoodLevelChange;
import thepit.verymc.events.PlayerDeath;
import thepit.verymc.events.PlayerJoin;
import thepit.verymc.events.PlayerQuit;
import thepit.verymc.events.PlayerRespawn;

public class main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		ConfigFileManager configManager = new ConfigFileManager(this);
		getServer().getPluginManager().registerEvents(new FoodLevelChange(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
		getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
		getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		getServer().getPluginManager().registerEvents(new EntityDamageByEntity(), this);
		getServer().getPluginManager().registerEvents(new PlayerRespawn(), this);
		
		getCommand("thepit").setExecutor(new ThePit());
		super.onEnable();
	}
	
	@Override
	public void onLoad() {

		super.onLoad();
	}
	
	@Override
	public void onDisable() {
		
		super.onDisable();
	}

}
