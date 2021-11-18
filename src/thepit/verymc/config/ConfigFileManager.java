package thepit.verymc.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import thepit.verymc.main;

public class ConfigFileManager {
	
	private static File config_file;
	private final String config_file_name = "thepit.config.yml";
	
	
	private static FileConfiguration config;
	private static main main;
	
	public static boolean config_load = false;
	
	public ConfigFileManager(main main) {
		this.main = main;
		CreateConfigFile();
	}
	
	public ConfigFileManager() {
		
	}

	private void CreateConfigFile() {
		config_file = new File(main.getDataFolder(), config_file_name);
		if(!config_file.exists()) {
			config_file.getParentFile().mkdir();
			main.saveResource(config_file_name, false);
		}
		
		config = new YamlConfiguration();
		
		try {
			
			config.load(config_file);

		} catch (Exception e) {
			System.out.println("Erreur: " + e.getMessage());
		}
	}
	
	public FileConfiguration getFileConfiguration() {
		return this.config;
	}

}
