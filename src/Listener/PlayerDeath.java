package Listener;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import Classes.Server;
import Classes.Var;
import Main.Main;

public class PlayerDeath implements Listener {

	public Main main;

	public PlayerDeath(Main main) {
		super();
		this.main = main;
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		event.setDeathMessage(null);
		Player player = (Player) event.getEntity();
		if (Server.getPlayers().contains(player))
			makeTeleport(player, player.getKiller());
	}

	@EventHandler
	public void onVoid(PlayerMoveEvent event) {

		Player player = event.getPlayer();
		if (player.getLocation().getY() <= 0 && Server.getPlayers().contains(player)) {
			makeTeleport(player, null);
		}
	}

	private void makeTeleport(Player player, Player killer) {
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		if(player.isDead())
			player.spigot().respawn();
		player.setHealth(20);
		player.setFoodLevel(20);
		player.teleport(Var.voidL);
		player.setGameMode(GameMode.SPECTATOR);

		if (killer != null) {
			List<String> deathMessages = main.getConfig().getStringList("DeathMessages");
			if (!deathMessages.isEmpty()) {
				Random rnd = new Random();
				String msg = deathMessages.get(rnd.nextInt(deathMessages.size()));
				msg.replaceAll("%p%", player.getName());
				msg.replaceAll("%k%", killer.getName());

				Bukkit.broadcastMessage(msg);
			}
		} else {
			List<String> voidDeathMessages = main.getConfig().getStringList("VoidDeathMessages");
			if (!voidDeathMessages.isEmpty()) {
				Random rnd = new Random();
				String msg = voidDeathMessages.get(rnd.nextInt(voidDeathMessages.size()));
				msg = msg.replaceAll("%p%", player.getName());

				Bukkit.broadcastMessage(msg);
			}
		}

		new BukkitRunnable() {

			int counter = 5;

			@Override
			public void run() {

				player.sendMessage("Getting back in " + counter);
				counter--;
				if (counter == 0 && player != null) {
					switch (Server.getColorByPlayer(player)) {

					case RED:
				        player.teleport(Var.redSpawn.add(0, 1, 0));
				        Server.makeChangesOfPlayer(player);
				        break;
				    case BLUE:
				        player.teleport(Var.blueSpawn.add(0, 1, 0));
				        Server.makeChangesOfPlayer(player);

				        break;
				    case GREEN:
				        player.teleport(Var.greenSpawn.add(0, 1, 0));
				        Server.makeChangesOfPlayer(player);
				        break;
				    case YELLOW:
				        player.teleport(Var.yellowSpawn.add(0, 1, 0));
				        Server.makeChangesOfPlayer(player);

				        break;
				    default:
				    	Server.makeChangesOfPlayer(player);

				    	break;
					
					}
					
					cancel();
					return;
				}
			}
		}.runTaskTimer(main, 20L, 20L);
	}
}
