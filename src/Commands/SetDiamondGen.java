package Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;
import Utils.Utils;

public class SetDiamondGen implements CommandExecutor {

	public Main main;

	public SetDiamondGen(Main main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player))
			return false;

		Player player = (Player) sender;

		if (args.length < 1)
			return false;

		if (args.length == 1) {
			Location pl = player.getLocation();
			double x = pl.getX();
			double y = pl.getY();
			double z = pl.getZ();
			main.setLocationInConfig("Diamond." + args[0], x, y, z);
			player.sendMessage(Utils.chat("&dDiamond &fgen number " + args[0] + " location setted."));
			return true;
		}

		return true;
	}

}
