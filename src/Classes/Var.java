package Classes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import Main.Main;

public class Var {

	private static FileConfiguration config = Main.getInstance().getConfig();
	
	public static World world = Bukkit.getWorld(getString("World"));
	public static Location lobby = new Location(world, getDouble("Lobby.x"), getDouble("Lobby.y"), getDouble("Lobby.z"), getFloat("Lobby.yaw"), getFloat("Lobby.pitch"));
	public static Location voidL = new Location(world, getDouble("Void.x"), getDouble("Void.y"), getDouble("Void.z"), getFloat("Void.yaw"), getFloat("Void.pitch"));
	
	public static Location redSpawn = new Location(world, getDouble("Red.Spawn.x"), getDouble("Red.Spawn.y"), getDouble("Red.Spawn.z"), getFloat("Red.Spawn.yaw"), getFloat("Red.Spawn.pitch"));
	public static Location blueSpawn = new Location(world, getDouble("Blue.Spawn.x"), getDouble("Blue.Spawn.y"), getDouble("Blue.Spawn.z"), getFloat("Blue.Spawn.yaw"), getFloat("Blue.Spawn.pitch"));
	public static Location greenSpawn = new Location(world, getDouble("Green.Spawn.x"), getDouble("Green.Spawn.y"), getDouble("Green.Spawn.z"), getFloat("Green.Spawn.yaw"), getFloat("Green.Spawn.pitch"));
	public static Location yellowSpawn = new Location(world, getDouble("Yellow.Spawn.x"), getDouble("Yellow.Spawn.y"), getDouble("Yellow.Spawn.z"), getFloat("Yellow.Spawn.yaw"), getFloat("Yellow.Spawn.pitch"));
	public static Location[] spawns = {redSpawn, blueSpawn, greenSpawn, yellowSpawn};
	
	public static Location redShopVilSpawn = new Location(world, getDouble("Red.Villager.Shop.x"), getDouble("Red.Villager.Shop.y"), getDouble("Red.Villager.Shop.z"), getFloat("Red.Villager.Shop.yaw"), getFloat("Red.Villager.Shop.pitch"));
	public static Location redDiamondVilSpawn = new Location(world, getDouble("Red.Villager.Diamond.x"), getDouble("Red.Villager.Diamond.y"), getDouble("Red.Villager.Diamond.z"), getFloat("Red.Villager.Diamond.yaw"), getFloat("Red.Villager.Diamond.pitch"));
	public static Location blueShopVilSpawn = new Location(world, getDouble("Blue.Villager.Shop.x"), getDouble("Blue.Villager.Shop.y"), getDouble("Blue.Villager.Shop.z"), getFloat("Blue.Villager.Shop.yaw"), getFloat("Blue.Villager.Shop.pitch"));
	public static Location blueDiamondVilSpawn = new Location(world, getDouble("Blue.Villager.Diamond.x"), getDouble("Blue.Villager.Diamond.y"), getDouble("Blue.Villager.Diamond.z"), getFloat("Blue.Villager.Diamond.yaw"), getFloat("Blue.Villager.Diamond.pitch"));
	public static Location greenShopVilSpawn = new Location(world, getDouble("Green.Villager.Shop.x"), getDouble("Green.Villager.Shop.y"), getDouble("Green.Villager.Shop.z"), getFloat("Green.Villager.Shop.yaw"), getFloat("Green.Villager.Shop.pitch"));
	public static Location greenDiamondVilSpawn = new Location(world, getDouble("Green.Villager.Diamond.x"), getDouble("Green.Villager.Diamond.y"), getDouble("Green.Villager.Diamond.z"), getFloat("Green.Villager.Diamond.yaw"), getFloat("Green.Villager.Diamond.pitch"));
	public static Location yellowShopVilSpawn = new Location(world, getDouble("Yellow.Villager.Shop.x"), getDouble("Yellow.Villager.Shop.y"), getDouble("Yellow.Villager.Shop.z"), getFloat("Yellow.Villager.Shop.yaw"), getFloat("Yellow.Villager.Sho.pitchp"));
	public static Location yellowDiamondVilSpawn = new Location(world, getDouble("Yellow.Villager.Diamond.x"), getDouble("Yellow.Villager.Diamond.y"), getDouble("Yellow.Villager.Diamond.z"), getFloat("Yellow.Villager.Diamond.yaw"), getFloat("Yellow.Villager.Diamond.pitch"));
	public static Location[] shopVils = {redShopVilSpawn, blueShopVilSpawn,
			greenShopVilSpawn, yellowShopVilSpawn};
	public static Location[] diamondVils = {redDiamondVilSpawn, blueDiamondVilSpawn,
			greenDiamondVilSpawn, yellowDiamondVilSpawn};
	
	public static Location redGen = new Location(world, getDouble("Red.Gen.x"), getDouble("Red.Gen.y"), getDouble("Red.Gen.z"));
	public static Location blueGen = new Location(world, getDouble("Blue.Gen.x"), getDouble("Blue.Gen.y"), getDouble("Blue.Gen.z"));
	public static Location greenGen = new Location(world, getDouble("Green.Gen.x"), getDouble("Green.Gen.y"), getDouble("Green.Gen.z"));
	public static Location yellowGen = new Location(world, getDouble("Yellow.Gen.x"), getDouble("Yellow.Gen.y"), getDouble("Yellow.Gen.z"));
	public static Location[] gens = {redGen, blueGen, greenGen, yellowGen};

	public static Location[] redBeds = {new Location(world, getDouble("Red.Bed.1.x"), getDouble("Red.Bed.1.y"), getDouble("Red.Bed.1.z")), new Location(world, getDouble("Red.Bed.2.x"), getDouble("Red.Bed.2.y"), getDouble("Red.Bed.2.z"))};
	public static Location[] blueBeds = {new Location(world, getDouble("Blue.Bed.1.x"), getDouble("Blue.Bed.1.y"), getDouble("Blue.Bed.1.z")), new Location(world, getDouble("Blue.Bed.2.x"), getDouble("Blue.Bed.2.y"), getDouble("Blue.Bed.2.z"))};
	public static Location[] greenBeds = {new Location(world, getDouble("Green.Bed.1.x"), getDouble("Green.Bed.1.y"), getDouble("Green.Bed.1.z")), new Location(world, getDouble("Green.Bed.2.x"), getDouble("Green.Bed.2.y"), getDouble("Green.Bed.2.z"))};
	public static Location[] yellowBeds = {new Location(world, getDouble("Yellow.Bed.1.x"), getDouble("Yellow.Bed.1.y"), getDouble("Yellow.Bed.1.z")), new Location(world, getDouble("Yellow.Bed.2.x"), getDouble("Yellow.Bed.2.y"), getDouble("Yellow.Bed.2.z"))};
	
	public static FileConfiguration getConfig() {
		return config;
	}

	public static void setConfig(FileConfiguration config) {
		Var.config = config;
	}
	
	private static String getString(String s) {
		if(!config.contains(s)) return null;
		return config.getString(s);
	}
	
	private static double getDouble(String s) {
		if(!config.contains(s)) return 0;
		return config.getDouble(s);
	}
	
	private static float getFloat(String s) {
		if(!config.contains(s)) return 0;
		return (float)config.getDouble(s);
	}
}
