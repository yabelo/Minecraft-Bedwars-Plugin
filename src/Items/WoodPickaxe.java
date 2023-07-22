package Items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class WoodPickaxe {

	private static int amount = 1; 
	private static int cost = 10; 
	private static Ores ore = Ores.IRON;
	private static String name = "Wood Pickaxe";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.WOOD_PICKAXE, amount), name, cost, ore, Enchantment.DIG_SPEED, 1);
}
