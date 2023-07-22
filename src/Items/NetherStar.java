package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Main.Main;

public class NetherStar {

	private static int amount = 1; 
	private static String name = "&aQuick Buy";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.NETHER_STAR, amount), name);
}
