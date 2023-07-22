package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class Shears {

	private static int amount = 1; 
	private static int cost = 10; 
	private static Ores ore = Ores.IRON;
	private static String name = "Shears";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.SHEARS, amount), name, cost, ore);
}
