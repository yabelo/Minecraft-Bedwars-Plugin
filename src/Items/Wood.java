package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class Wood {

	private static int amount = 16; 
	private static int cost = 4; 
	private static Ores ore = Ores.GOLD;
	private static String name = "Wood";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.WOOD, amount), name, cost, ore);
}
