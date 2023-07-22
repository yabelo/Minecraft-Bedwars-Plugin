package Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Inventories.ShopVillagerInv;
import Main.Main;
import Utils.Utils;

public class ClickInventory implements Listener {

	public Main main;

	public ClickInventory(Main main) {
		super();
		this.main = main;
	}

	@EventHandler
	public void onClickInventory(InventoryClickEvent event) {
		if(event.getCurrentItem() == null || event.getClickedInventory() == null) return;
		if (event.getClickedInventory().getName() != ShopVillagerInv.getShopInv().getName())
			return;

		event.setCancelled(true);

		Player player = (Player) event.getWhoClicked();
		
		ItemStack item = event.getCurrentItem();
		ItemMeta itemMeta = item.getItemMeta();

		if (itemMeta == null || itemMeta.getLore() == null || itemMeta.getLore().isEmpty()) {
			return;
		}

		String[] strings = itemMeta.getLore().toString().split(" ");
		
		int cost = Integer.parseInt(strings[1]);
		Material m = null;

		if (strings[2].equals("iron]"))
		    m = Material.IRON_INGOT;
		else if (strings[2].equals("gold]"))
		    m = Material.GOLD_INGOT;
		else if (strings[2].equals("diamond]"))
		    m = Material.DIAMOND;
		else if (strings[2].equals("emerald]"))
		    m = Material.EMERALD;
		
		buyItem(player, m, cost, item);
	}

	private void buyItem(Player player, Material m, int cost, ItemStack item) {
		
		if(m == null) return;

		for (int i = 0; i < player.getInventory().getSize(); i++) {
			if(player.getInventory().getItem(i) == null);
			else if (player.getInventory().getItem(i).getType() == m) {
				ItemStack ingot = player.getInventory().getItem(i);
				
				if(!canAffordItem(player, ingot, cost)) {
					sendMessage(player, m);
				}
				else {
					if(item.getType().equals(Material.STONE_SWORD) || item.getType().equals(Material.IRON_SWORD)) {
						player.getInventory().setItem(0, item);
						return;
					}
					else if(item.getType().equals(Material.IRON_BOOTS)) {
						player.getInventory().setBoots(item);
						player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
						return;
					}
					else if(item.getType().equals(Material.CHAINMAIL_BOOTS)) {
						player.getInventory().setBoots(item);
						player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
						return;
					}
					player.getInventory().addItem(item);
				}
				return;
			}
		}
		
		sendMessage(player, m);
	}
	
	private void sendMessage(Player player, Material m) {
		String str = m.toString().toLowerCase().replace("_", " ");
		player.sendMessage(Utils.chat("&cYou don't have enough " + str + "s"));
	}
	
	private boolean canAffordItem(Player player, ItemStack ingot, int cost) {
		
		if (ingot.getAmount() < cost) {
			return false;
		} else if (ingot.getAmount() == cost) {
			player.getInventory().removeItem(ingot);
			return true;
		} else {
			ingot.setAmount(ingot.getAmount() - cost);
			return true;
		}
	}
}
