package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class JumpBoostPotion {

	private static int amount = 1; 
	private static int cost = 2; 
	private static Ores ore = Ores.EMERALD;
	private static String name = "Jump Boost Potion";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.POTION, amount, (byte)8), name, cost, ore);
}
