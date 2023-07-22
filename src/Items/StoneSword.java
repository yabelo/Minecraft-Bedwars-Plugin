package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class StoneSword {

	private static int amount = 1; 
	private static int cost = 10; 
	private static Ores ore = Ores.IRON;
	private static String name = "Stone Sword";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.STONE_SWORD, amount), name, cost, ore);
}
