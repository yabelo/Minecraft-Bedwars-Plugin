package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class Tnt {

	private static int amount = 1; 
	private static int cost = 4; 
	private static Ores ore = Ores.GOLD;
	private static String name = "Tnt";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.TNT, amount), name, cost, ore);
}
