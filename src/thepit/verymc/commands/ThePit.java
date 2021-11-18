package thepit.verymc.commands;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import thepit.verymc.player.PlayerInfo;
import thepit.verymc.player.PlayerManager;

public class ThePit implements CommandExecutor {
	
	private PlayerManager playerManager;
	
	public ThePit() {
		playerManager = new PlayerManager();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if(args.length < 1) {
			sender.sendMessage("§c/thepit §e<§callplayer§e>");
			return false;
		}
		if(args[0].equalsIgnoreCase("allplayer")) {
			sender.sendMessage("§eListe des joueurs: \n§7");
			int i = 0;
			for(Map.Entry<UUID, PlayerInfo> player : playerManager.players.entrySet()) {
				PlayerInfo player_info = player.getValue();
				sender.sendMessage("§7[" + i + "] §e" + player.getKey() + ", " + Bukkit.getPlayer(player.getKey()).getName() + ": §akill: " + player_info.kill + ", death: " + player_info.death);
				i++;
			}
		}
		return false;
	}

}
