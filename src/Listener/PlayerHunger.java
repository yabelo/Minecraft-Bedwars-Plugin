package Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerHunger implements Listener{
	
	@EventHandler
	public void onPlayerHunger(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

}
