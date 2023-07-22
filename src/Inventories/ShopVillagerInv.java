package Inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Items.Arrows;
import Items.Bow;
import Items.ChainmainBoots;
import Items.GoldenApple;
import Items.IronBoots;
import Items.IronSword;
import Items.JumpBoostPotion;
import Items.NetherStar;
import Items.Obsidian;
import Items.Shears;
import Items.StoneSword;
import Items.Tnt;
import Items.Wood;
import Items.WoodAxe;
import Items.WoodPickaxe;
import Items.Wool;
import Main.Main;
import Utils.Utils;

public class ShopVillagerInv {
	
	private static Inventory inv = Bukkit.createInventory(null, 54, Utils.chat("&7Quick Buy"));

	public static Inventory getShopInv() {
		
		inv.setItem(0, NetherStar.item);
		/*
		 * inv.setItem(1, getItemStack(new ItemStack(Material.STAINED_CLAY, 1, (byte)1),
		 * "&8Blocks")); inv.setItem(2, getItemStack(new ItemStack(Material.GOLD_SWORD),
		 * "&8Swords")); inv.setItem(3, getItemStack(new
		 * ItemStack(Material.CHAINMAIL_BOOTS), "&8Boots")); inv.setItem(4,
		 * getItemStack(new ItemStack(Material.STONE_PICKAXE), "&8Tools"));
		 * inv.setItem(5, getItemStack(new ItemStack(Material.BOW), "&8Bows"));
		 * inv.setItem(6, getItemStack(new ItemStack(Material.POTATO), "&8Potions"));
		 * inv.setItem(7, getItemStack(new ItemStack(Material.TNT), "&8Utilities"));
		 */
		
		inv.setItem(9, Main.getItemStack(new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)5), "&c"));
		inv.setItem(10, Main.getItemStack(new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)7), "&e"));
		inv.setItem(11, Main.getItemStack(new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)7), "&d"));
		inv.setItem(12, Main.getItemStack(new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)7), "&c"));
		inv.setItem(13, Main.getItemStack(new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)7), "&b"));
		inv.setItem(14, Main.getItemStack(new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)7), "&4"));
		inv.setItem(15, Main.getItemStack(new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)7), "&l"));
		inv.setItem(16, Main.getItemStack(new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)7), "&g"));
		inv.setItem(17, Main.getItemStack(new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)7), "&6"));
		
		inv.setItem(19, Wool.item);
		inv.setItem(20, StoneSword.item);
		inv.setItem(21, ChainmainBoots.item);
		inv.setItem(23, Bow.item);
		inv.setItem(24, JumpBoostPotion.item);
		inv.setItem(25, Tnt.item);

		inv.setItem(28, Wood.item);
		inv.setItem(29, IronSword.item);
		inv.setItem(30, IronBoots.item);
		inv.setItem(31, Shears.item);
		inv.setItem(32, Arrows.item);
		
		inv.setItem(37, Obsidian.item);
		inv.setItem(38, WoodPickaxe.item);
		inv.setItem(39, WoodAxe.item);
		inv.setItem(43, GoldenApple.item);

		return inv;
	}

}
