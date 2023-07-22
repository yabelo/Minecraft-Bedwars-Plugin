package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class Wool {

	private static int amount = 16; 
	private static int cost = 4; 
	private static Ores ore = Ores.IRON;
	private static String name = "Wool";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.WOOL, amount), name, cost, ore);
}
