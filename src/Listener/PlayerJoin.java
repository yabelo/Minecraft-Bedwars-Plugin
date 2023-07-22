package Listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Classes.Server;
import Classes.Var;
import Enums.Status;
import Main.Main;

public class PlayerJoin implements Listener{
	
	public Main main;

	public PlayerJoin(Main main) {
		super();
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setHealth(20);
		player.setFoodLevel(20);
		
		if(Server.getStatus() == Status.RUN && !Server.getPlayers().contains(player)) {
			player.setGameMode(GameMode.SPECTATOR);
		}
		else if(Server.getPlayers().contains(player)) {
			switch (Server.getColorByPlayer(player)) {

			case RED:
				player.teleport(Var.redSpawn);

				break;
			case BLUE:
				player.teleport(Var.blueSpawn);

				break;
			case GREEN:
				player.teleport(Var.greenSpawn);

				break;
			case YELLOW:
				player.teleport(Var.yellowSpawn);

				break;
			default:
				break;

			}
		}
		else {
			try {
				FileConfiguration config = main.getConfig();
				World world = Bukkit.getWorld(config.getString("World"));
				Location loc = new Location(world, config.getDouble("Lobby.x"), config.getDouble("Lobby.y"), config.getDouble("Lobby.z"), (float)config.getDouble("Lobby.yaw"), (float)config.getDouble("Lobby.pitch"));
				player.teleport(loc);
			} catch (NullPointerException ex) {
				
			}
			
		}
		
	}

}
