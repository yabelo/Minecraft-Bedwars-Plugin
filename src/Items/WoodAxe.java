package Items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class WoodAxe {

	private static int amount = 1; 
	private static int cost = 10; 
	private static Ores ore = Ores.IRON;
	private static String name = "Wood Axe";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.WOOD_AXE, amount), name, cost, ore, Enchantment.DIG_SPEED, 1);
}
