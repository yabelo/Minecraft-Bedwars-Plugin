package Classes;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

import Utils.Utils;

public class Villagers {
	
	public static void SpawnShopVil(Location l) {
		
		Villager villager = (Villager) l.getWorld().spawnEntity(l, EntityType.VILLAGER);

		villager.setCustomName(Utils.chat("&7&lItem Shop"));
		villager.setAdult();
		villager.setAgeLock(true);
		villager.setHealth(20);
		villager.setCustomNameVisible(true);
		villager.setCanPickupItems(false);
	}

	public static void SpawnDiamondVil(Location l) {
		
		Villager villager = (Villager) l.getWorld().spawnEntity(l, EntityType.VILLAGER);

		villager.setCustomName(Utils.chat("&b&lDiamond Shop"));
		villager.setAdult();
		villager.setAgeLock(true);
		villager.setHealth(20);
		villager.setCustomNameVisible(true);
		villager.setCanPickupItems(false);
	}
}
