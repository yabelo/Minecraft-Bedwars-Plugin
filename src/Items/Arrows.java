package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class Arrows {

	private static int amount = 6; 
	private static int cost = 4; 
	private static Ores ore = Ores.GOLD;
	private static String name = "Arrows";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.ARROW, amount), name, cost, ore);
}
