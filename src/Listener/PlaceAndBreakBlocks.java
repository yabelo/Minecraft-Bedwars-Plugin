package Listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import Classes.Server;
import Classes.Var;
import Enums.Colors;
import Enums.Status;
import Main.Main;
import Utils.Utils;

public class PlaceAndBreakBlocks implements Listener {

	public Main main;

	public PlaceAndBreakBlocks(Main main) {
		super();
		this.main = main;
	}

	@EventHandler
	public void onPlayerPlaceBlocks(BlockPlaceEvent event) {

		if (Server.getStatus() == Status.STOP)
			return;
		if (Server.getStatus() == Status.START) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(Utils.chat("&cYou can't place that block."));
			return;
		}
		
		if(event.getBlock().getType() == Material.TNT) {
			event.getBlock().setType(Material.AIR);
			event.getBlock().getWorld().spawn(event.getBlock().getLocation().add(0, 0.5, 0), TNTPrimed.class);
		}

		Server.placedBlocks.add(event.getBlock().getLocation());
	}


	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	public void onTntExplode(BlockExplodeEvent event) {
		if(event.blockList().isEmpty()) return;
		for(Block block : event.blockList()) {
			if(!Server.placedBlocks.contains(block)) {
				event.blockList().remove(block);
				event.setCancelled(true);
			}
			else {
				event.setCancelled(false);
			}
		}
	}

	@EventHandler
	public void onPlayerBreakBlocks(BlockBreakEvent event) {

		if (Server.getStatus() == Status.STOP)
			return;
		
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Location location = block.getLocation();
		if(checkIfBlockIsBed(location) != null) {
			if (Server.getColorByPlayer(player) == checkIfBlockIsBed(location)) {
				player.sendMessage(Utils.chat("&cYou can't break your own bed."));
				event.setCancelled(true);
			}
			else
				breakBed(event.getPlayer(), checkIfBlockIsBed(location));

		}
		else if (!Server.placedBlocks.contains(event.getBlock().getLocation()) || Server.getStatus() == Status.START) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(Utils.chat("&cYou can't break that block."));
			return;
		}

		Server.placedBlocks.remove(event.getBlock().getLocation());
	}

	private Colors checkIfBlockIsBed(Location loc) {

		if (loc.equals(Var.redBeds[0]) || loc.equals(Var.redBeds[1])) {
			return Colors.RED;
		} else if (loc.equals(Var.blueBeds[0]) || loc.equals(Var.blueBeds[1])) {
			return Colors.BLUE;
		} else if (loc.equals(Var.greenBeds[0]) || loc.equals(Var.greenBeds[1])) {
			return Colors.GREEN;
		} else if (loc.equals(Var.yellowBeds[0]) || loc.equals(Var.yellowBeds[1])) {
			return Colors.YELLOW;
		}
		
		return null;
	}

	private void breakBed(Player player, Colors color) {
		
		for(Player p : Server.getPlayers()){
			p.sendMessage(player.getName() + " broke team " + color.toString().toLowerCase() + "'s bed.");
			p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1f, 1f);
		}
	}
}
