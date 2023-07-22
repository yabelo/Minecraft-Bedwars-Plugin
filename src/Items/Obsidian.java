package Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Enums.Ores;
import Main.Main;

public class Obsidian {

	private static int amount = 4; 
	private static int cost = 4; 
	private static Ores ore = Ores.EMERALD;
	private static String name = "Obsidian";
	public static ItemStack item = Main.getItemStack(new ItemStack(Material.OBSIDIAN, amount), name, cost, ore);
}
