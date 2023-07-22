package Main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import Classes.Server;
import Commands.JoinBW;
import Commands.SetBed;
import Commands.SetDeathPlace;
import Commands.SetDiamondGen;
import Commands.SetEmeraldGen;
import Commands.SetGen;
import Commands.SetLobby;
import Commands.SetSpawn;
import Commands.SetVil;
import Commands.StartBW;
import Commands.StopBW;
import Enums.Ores;
import Listener.ClickInventory;
import Listener.ClickVillager;
import Listener.PlaceAndBreakBlocks;
import Listener.PlayerDeath;
import Listener.PlayerHunger;
import Listener.PlayerJoin;
import Utils.Utils;

public class Main extends JavaPlugin {

	private static Plugin instance;

	@Override
	public void onEnable() {

		instance = this;
		
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
		getServer().getPluginManager().registerEvents(new PlaceAndBreakBlocks(this), this);
		getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
		getServer().getPluginManager().registerEvents(new PlayerHunger(), this);
		getServer().getPluginManager().registerEvents(new ClickVillager(this), this);
		getServer().getPluginManager().registerEvents(new ClickInventory(this), this);
		
		if(!getConfig().contains("World"))
			getConfig().set("World", "world");

		getCommand("setlobby").setExecutor(new SetLobby(this));
		getCommand("setspawn").setExecutor(new SetSpawn(this));
		getCommand("setshopvil").setExecutor(new SetVil(this));
		getCommand("setdiamondvil").setExecutor(new SetVil(this));
		getCommand("setbed").setExecutor(new SetBed(this));
		getCommand("setgen").setExecutor(new SetGen(this));
		getCommand("setdiamondgen").setExecutor(new SetDiamondGen(this));
		getCommand("setemeraldgen").setExecutor(new SetEmeraldGen(this));
		getCommand("stopbw").setExecutor(new StopBW(this));
		getCommand("startbw").setExecutor(new StartBW(this));
		getCommand("joinbw").setExecutor(new JoinBW(this));
		getCommand("setdeathplace").setExecutor(new SetDeathPlace(this));

		addDeathMessages();
		saveConfig();
	}
	
	@Override
	public void onDisable() {
		
		Server.stopGame();
	}

	private void addDeathMessages() {
		List<String> deathMessages = new ArrayList<>();
		deathMessages.add("%p% taked the L by %k%.");
		deathMessages.add("%p% were killed by %k%.");
		deathMessages.add("%k% just showed %p% from where the fish pees.");
		deathMessages.add("%k% just kicked the fuck out of %p%.");
		deathMessages.add("%k% bozoed %p%.");
		deathMessages.add("%p% thought he can fight %k%.");
		
		List<String> voidDeathMessages = new ArrayList<>();
		voidDeathMessages.add("%p% took the L to the void.");
		voidDeathMessages.add("%p% fell into the void.");
		voidDeathMessages.add("the void ate %p%.");
		
		
		getConfig().set("DeathMessages", deathMessages);
		getConfig().set("VoidDeathMessages", voidDeathMessages);
	}

	public static Plugin getInstance() {
		return instance;
	}
	

	public void setLocationInConfig(String label, double x, double y, double z, double yaw, double pitch) {
	    double[] nums = {x, y, z, yaw, pitch};

	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] < 0) {
	            nums[i] = -nums[i];  // Make negative numbers positive
	            nums[i] = Double.valueOf(new DecimalFormat("#.###").format(nums[i])); // Format positive numbers
	            nums[i] = -nums[i];  // Make positive numbers negative again
	        } else {
	            nums[i] = Double.valueOf(new DecimalFormat("#.###").format(nums[i])); // Format non-negative numbers
	        }
	    }

	    getConfig().set(label + ".x", nums[0]);
	    getConfig().set(label + ".y", nums[1]);
	    getConfig().set(label + ".z", nums[2]);
	    getConfig().set(label + ".yaw", nums[3]);
	    getConfig().set(label + ".pitch", nums[4]);

	    saveConfig();
	}
	
	public void setLocationInConfig(String label, double x, double y, double z) {
	    double[] nums = {x, y, z};

	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] < 0) {
	            nums[i] = -nums[i];  // Make negative numbers positive
	            nums[i] = Double.valueOf(new DecimalFormat("#.###").format(nums[i])); // Format positive numbers
	            nums[i] = -nums[i];  // Make positive numbers negative again
	        } else {
	            nums[i] = Double.valueOf(new DecimalFormat("#.###").format(nums[i])); // Format non-negative numbers
	        }
	    }

	    getConfig().set(label + ".x", nums[0]);
	    getConfig().set(label + ".y", nums[1]);
	    getConfig().set(label + ".z", nums[2]);

	    saveConfig();
	}
	
	public static ItemStack getItemStack(ItemStack item, String name) {
		
		ItemMeta meta = item.getItemMeta();
		meta.spigot().setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setDisplayName(Utils.chat("&r&f" + name));

		item.setItemMeta(meta);
		
		return item;
	}
	
	public static ItemStack getItemStack(ItemStack item, String name, int cost, Ores ore) {
		
		ItemMeta meta = item.getItemMeta();
		meta.spigot().setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setDisplayName(Utils.chat("&r&f" + name));
		
		List<String> lore = new ArrayList<>();
		lore.add(Utils.chat("&r&8Costs " + cost + " " + ore.toString().toLowerCase()));
		
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		return item;
	}

	public static ItemStack getItemStack(ItemStack item, String name, int cost, Ores ore, Enchantment enchantment, int level) {
		
		ItemMeta meta = item.getItemMeta();
		meta.spigot().setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(enchantment, level, true);
		meta.setDisplayName(Utils.chat("&r&f" + name));
		
		List<String> lore = new ArrayList<>();
		lore.add(Utils.chat("&r&8Costs " + cost + " " + ore.toString().toLowerCase()));
		
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		return item;
	}
}
