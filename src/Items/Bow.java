package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class Bow {

	private static int amount = 1; 
	private static int cost = 6; 
	private static Ores ore = Ores.GOLD;
	private static String name = "Bow";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.BOW, amount), name, cost, ore);
}
