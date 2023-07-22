package Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;
import Utils.Utils;

public class SetVil implements CommandExecutor {

	public Main main;

	public SetVil(Main main) {
		super();
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player))
			return false;

		Player player = (Player) sender;

		if (args.length < 1)
			return false;
		
		if(args.length == 1) {
			Location pl = player.getLocation();
			double x = pl.getX();
			double y = pl.getY();
			double z = pl.getZ();
			double yaw = pl.getYaw();
			double pitch = pl.getPitch();
			if(label.equalsIgnoreCase("setshopvil")) {
				send(args[0], "shop", x, y,
						z, yaw, pitch);
				player.sendMessage(Utils.chat("&d" + args[0] +  " &fshop villager location setted."));
			}
			else if(label.equalsIgnoreCase("setdiamondvil")) {
				send("red", "diamond", x, y,
						z, yaw, pitch);
				player.sendMessage(Utils.chat("&d" + args[0] +  " &fdiamond villager location setted."));
			}

			return true;
		}

		return true;
	}
	
	private void send(String team, String label, double x, double y, double z, double yaw, double pitch) {
		
		String f = team.substring(0, 1);
		String a = label.substring(0, 1);
		
		main.setLocationInConfig(team.replaceFirst(f, f.toUpperCase()) + ".Villager." + label.replaceFirst(a, a.toUpperCase()), x, y,
				z, yaw, pitch);
	}

}
