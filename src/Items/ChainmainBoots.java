package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class ChainmainBoots {

	private static int amount = 1; 
	private static int cost = 40; 
	private static Ores ore = Ores.IRON;
	private static String name = "Chainmain Boots";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.CHAINMAIL_BOOTS, amount), name, cost, ore);
}
