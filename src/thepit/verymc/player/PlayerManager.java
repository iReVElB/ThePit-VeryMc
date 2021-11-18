package thepit.verymc.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerManager {
	public static Map<UUID, PlayerInfo> players = new HashMap<>();
	
	public void addPlayer(Player player_added) {
		UUID player_uuid = player_added.getUniqueId();
		if(!getPlayerExist(player_uuid)) {
			players.put(player_uuid, new PlayerInfo());
		}
		PlayerListConsole();
	}
	
	public void removePlayer(Player player_removed) {
		players.remove(player_removed.getUniqueId());
		PlayerListConsole();
	}
	
	public boolean getPlayerExist(UUID player_uuid) {
		Boolean exist = false;
		
		for(Map.Entry<UUID, PlayerInfo> player : players.entrySet()) {
			if(player.getKey() == player_uuid) {
				exist = true;
			}
		}
		
		return exist;
	}
	
	public PlayerInfo getPlayerInfo(Player player) {
		PlayerInfo player_info = players.get(player.getUniqueId());
		if(player_info != null) {
			return player_info;
		} else {
			Bukkit.getServer().getPlayer(player.getUniqueId()).kickPlayer("§cErreur, vous n'êtes pas sync avec le serveur.");
			return null;
		}
	}
	
	public void PlayerListConsole() {
		//debug
		System.out.println("Players: ");
		int i = 0;
		for(Map.Entry<UUID, PlayerInfo> player : players.entrySet()) {
			PlayerInfo player_info = player.getValue();
			System.out.println("["+i+"] (" + Bukkit.getPlayer(player.getKey()).getName() + "): kill: " + player_info.kill + " death: " + player_info.death);
			i++;
		}
		//
	}
}
