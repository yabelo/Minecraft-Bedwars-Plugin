package Listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import Classes.Server;
import Enums.Status;
import Inventories.DiamondVillagerInv;
import Inventories.ShopVillagerInv;
import Main.Main;
import Utils.Utils;

public class ClickVillager implements Listener{
	
	public Main main;

	public ClickVillager(Main main) {
		super();
		this.main = main;
	}
	
	@EventHandler
	public void onRightClickVillager(PlayerInteractEntityEvent event) {
		if(event.getRightClicked().getType() != EntityType.VILLAGER) return;
		if(event.getRightClicked().getCustomName() == null) return;
		if(event.getRightClicked().getCustomName().equals(Utils.chat("&7&lItem Shop"))) {
			event.setCancelled(true);
			event.getPlayer().closeInventory();
			event.getPlayer().openInventory(ShopVillagerInv.getShopInv());
		}
		else if(event.getRightClicked().getCustomName().equals(Utils.chat("&b&lDiamond Shop"))) {
			event.setCancelled(true);
			event.getPlayer().closeInventory();
			event.getPlayer().openInventory(DiamondVillagerInv.getShopInv());
		}
		
	}
	
	@EventHandler
	public void onLeftClickVillager(EntityDamageEvent event) {
		if(event.getEntity().getType() != EntityType.VILLAGER) return;
		if(Server.getStatus() == Status.RUN) event.setCancelled(true);
	}

}
