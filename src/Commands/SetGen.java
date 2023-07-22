package Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;
import Utils.Utils;

public class SetGen implements CommandExecutor {

	public Main main;

	public SetGen(Main main) {
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
			send(args[0], ".Gen", x, (y + 0.5), z);
			player.sendMessage(Utils.chat("&d" + args[0] + " &fgen location setted."));
			return true;
		}

		return true;
	}

	private void send(String team, String label, double x, double y, double z) {

		String f = team.substring(0, 1);
		String a = label.substring(0, 1);

		main.setLocationInConfig(team.replaceFirst(f, f.toUpperCase()) + label.replaceFirst(a, a.toUpperCase()), x, y, z);
	}
}
