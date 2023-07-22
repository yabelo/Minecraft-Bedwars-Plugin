package Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;

public class SetDeathPlace implements CommandExecutor{
	
	public Main main;

	public SetDeathPlace(Main main) {
		super();
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player))
			return false;
		
		Player player = (Player) sender;
		
		Location pl = player.getLocation();
		double x = pl.getX();
		double y = pl.getY();
		double z = pl.getZ();
		double yaw = pl.getYaw();
		double pitch = pl.getPitch();
		
		main.setLocationInConfig("Void", x, y, z, yaw, pitch);
		
		return true;
	}

}
