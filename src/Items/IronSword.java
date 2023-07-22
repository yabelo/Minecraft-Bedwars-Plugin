package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class IronSword {

	private static int amount = 1; 
	private static int cost = 7; 
	private static Ores ore = Ores.GOLD;
	private static String name = "Iron Sword";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.IRON_SWORD, amount), name, cost, ore);
}
