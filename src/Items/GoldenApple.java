package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class GoldenApple {

	private static int amount = 1; 
	private static int cost = 3; 
	private static Ores ore = Ores.GOLD;
	private static String name = "Golden Apple";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.GOLDEN_APPLE, amount), name, cost, ore);
}
