package Inventories;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import Utils.Utils;

public class DiamondVillagerInv {
	
	private static Inventory inv = Bukkit.createInventory(null, 54, Utils.chat("&7Quick Buy"));

	public static Inventory getShopInv() {


		return inv;
	}

}
