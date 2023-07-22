package Classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import Enums.Colors;
import Enums.Status;
import Main.Main;
import Utils.Utils;

public class Server {

	private static Status status = Status.STOP;
	private static ArrayList<Player> players = new ArrayList<>(4);
	private static Colors[] colors = { Colors.RED, Colors.BLUE, Colors.GREEN, Colors.YELLOW };
	private static Hashtable<Colors, Player> colorToPlayer = new Hashtable<Colors, Player>(4);
	public static ArrayList<Location> placedBlocks = new ArrayList<>();
	public static HashSet<Colors> brokenBeds = new HashSet<>();

	public static Status getStatus() {
		return status;
	}

	public static void setStatus(Status status) {
		Server.status = status;
	}

	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static boolean addPlayer(Player player) {

		if (status == Status.RUN) {
			player.sendMessage(Utils.chat("&cGame already started."));
			return false;
		}
		if (players.contains(player)) {
			player.sendMessage(Utils.chat("&cYou already in the game."));
			return false;
		}

		try {
			players.add(player);
			player.sendMessage(Utils.chat("&dYou added into the game!"));
			status = Status.START;
			player.teleport(Var.lobby);
			player.getInventory().clear();
			player.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
		    player.getInventory().setChestplate(new ItemStack(Material.AIR, 1));
		    player.getInventory().setLeggings(new ItemStack(Material.AIR, 1));
		    player.getInventory().setBoots(new ItemStack(Material.AIR, 1));
			if (players.size() >= 2 && status == Status.START) {
				startGame();
			}
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static int playersSize() {
		return players.size();
	}

	public static void startGame() {
		addPlayersToTeams();
		sendStartingMessage();

		new BukkitRunnable() {

			@Override
			public void run() {
				status = Status.RUN;

				teleportPlayers();
				for (Player player : players)
					makeChangesOfPlayer(player);

				spawnVillagers();
				startGens();
			}
		}.runTaskLater(Main.getInstance(), 20L * 5);

	}

	private static void startGens() {

		new BukkitRunnable() {
			int goldCounter = 0;

			// int diamondCounter = 0;
			// int emeraldCounter = 0;
			@Override
			public void run() {

				if (status == Status.STOP) {
					cancel();
					return;
				}

				for (Location loc : Var.gens) {
					loc.getWorld().dropItem(loc, new ItemStack(Material.IRON_INGOT, 2));
				}
				goldCounter++;
				// diamondCounter++;
				// emeraldCounter++;
				if (goldCounter == 4) {
					for (Location loc : Var.gens) {
						loc.getWorld().dropItem(loc, new ItemStack(Material.GOLD_INGOT, 1));
						goldCounter = 0;
					}
				}
			}
		}.runTaskTimer(Main.getInstance(), 20L, 20L);
	}

	private static void spawnVillagers() {

		for (int i = 0; i < Var.shopVils.length; i++) {
			if (Var.shopVils[i] != null) {
				Villagers.SpawnShopVil(Var.shopVils[i]);
			}
		}
		for (int i = 0; i < Var.diamondVils.length; i++) {
			if (Var.diamondVils[i] != null) {
				Villagers.SpawnDiamondVil(Var.diamondVils[i]);
			}
		}
	}

	private static void teleportPlayers() {

		for (Player player : players) {
			if(player != null) {
				switch (getColorByPlayer(player)) {

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
		}
	}

	private static void sendStartingMessage() {

		for (Player player : players) {

			new BukkitRunnable() {
				int counter = 6;

				@Override
				public void run() {
					counter--;
					switch (counter) {
					case 5:
						player.sendMessage(Utils.chat("Starting in &e5"));
						break;
					case 4:
						player.sendMessage(Utils.chat("Starting in &34"));
						break;
					case 3:
						player.sendMessage(Utils.chat("Starting in &c3"));
						break;
					case 2:
						player.sendMessage(Utils.chat("Starting in &b2"));
						break;
					case 1:
						player.sendMessage(Utils.chat("Starting in &a1"));

						return;
					}
				}
			}.runTaskTimer(Main.getInstance(), 20L, 20L);
		}
	}

	private static void addPlayersToTeams() {

		for (int i = 0; i < players.size(); i++) {
			colorToPlayer.put(colors[i], players.get(i));
		}

	}

	public static Player getPlayerByColor(Colors color) {
		if (colorToPlayer.containsKey(color)) {
			return colorToPlayer.get(color);
		} else
			return null;
	}

	public static Colors getColorByPlayer(Player player) {

		if (colorToPlayer.containsValue(player)) {
			for (Entry<Colors, Player> entry : colorToPlayer.entrySet()) {
				if (entry.getValue() == player) {
					return entry.getKey();
				}
			}
		}

		return null;
	}

	public static void makeChangesOfPlayer(Player player) {

		player.setHealth(20);
		player.setAllowFlight(false);
		player.setExp(0);
		player.getInventory().clear();
		player.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
	    player.getInventory().setChestplate(new ItemStack(Material.AIR, 1));
	    player.getInventory().setLeggings(new ItemStack(Material.AIR, 1));
	    player.getInventory().setBoots(new ItemStack(Material.AIR, 1));
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2, 99999999));
		player.setGameMode(GameMode.SURVIVAL);

		ItemStack s = new ItemStack(Material.WOOD_SWORD);
		ItemMeta m = s.getItemMeta();
		m.spigot().setUnbreakable(true);
		m.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		s.setItemMeta(m);
		player.getInventory().setItem(0, s);
		
		ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
		helmetMeta.spigot().setUnbreakable(true);
		helmetMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

		ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
		chestMeta.spigot().setUnbreakable(true);
		chestMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
		leggingsMeta.spigot().setUnbreakable(true);
		leggingsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
		bootsMeta.spigot().setUnbreakable(true);
		bootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

		switch (getColorByPlayer(player)) {

		case RED:
			helmetMeta.setColor(Color.RED);
			helmet.setItemMeta(helmetMeta);
			
			chestMeta.setColor(Color.RED);
			chest.setItemMeta(chestMeta);

			leggingsMeta.setColor(Color.RED);
			leggings.setItemMeta(leggingsMeta);
			
			bootsMeta.setColor(Color.RED);
			boots.setItemMeta(bootsMeta);
			
			break;
		case BLUE:
			helmetMeta.setColor(Color.BLUE);
			helmet.setItemMeta(helmetMeta);
			
			chestMeta.setColor(Color.BLUE);
			chest.setItemMeta(chestMeta);

			leggingsMeta.setColor(Color.BLUE);
			leggings.setItemMeta(leggingsMeta);
			
			bootsMeta.setColor(Color.BLUE);
			boots.setItemMeta(bootsMeta);

			break;
		case GREEN:
			helmetMeta.setColor(Color.GREEN);
			helmet.setItemMeta(helmetMeta);
			
			chestMeta.setColor(Color.GREEN);
			chest.setItemMeta(chestMeta);

			leggingsMeta.setColor(Color.GREEN);
			leggings.setItemMeta(leggingsMeta);
			
			bootsMeta.setColor(Color.GREEN);
			boots.setItemMeta(bootsMeta);
			break;
		case YELLOW:
			helmetMeta.setColor(Color.YELLOW);
			helmet.setItemMeta(helmetMeta);
			
			chestMeta.setColor(Color.YELLOW);
			chest.setItemMeta(chestMeta);

			leggingsMeta.setColor(Color.YELLOW);
			leggings.setItemMeta(leggingsMeta);
			
			bootsMeta.setColor(Color.YELLOW);
			boots.setItemMeta(bootsMeta);
			break;
		default:
			break;

		}

		player.getInventory().setHelmet(helmet);
		player.getInventory().setChestplate(chest);
		player.getInventory().setLeggings(leggings);
		player.getInventory().setBoots(boots);

	}

	public static void stopGame() {
		for (Player p : players) {
			p.sendMessage(Utils.chat("&dGame ended!"));
		}

		status = Status.STOP;
		if(!players.isEmpty())
			players.clear();
		if(!colorToPlayer.isEmpty())
			colorToPlayer.clear();

		if(!placedBlocks.isEmpty())
			for (Location l : placedBlocks) {
				l.getBlock().setType(Material.AIR);
			}

		for (Entity e : Var.world.getEntities()) {
			if (e.getType() == EntityType.VILLAGER || e.getType() == EntityType.DROPPED_ITEM) {
				e.remove();
			}
		}
	}
}
