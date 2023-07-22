package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class IronBoots {

	private static int amount = 1; 
	private static int cost = 12; 
	private static Ores ore = Ores.GOLD;
	private static String name = "Iron Boots";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.IRON_BOOTS, amount), name, cost, ore);
}
