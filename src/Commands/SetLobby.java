package Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;
import Utils.Utils;

public class SetLobby implements CommandExecutor {

	public Main main;

	public SetLobby(Main main) {
		super();
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player))
			return false;

		Player player = (Player) sender;

		try {
			if (args.length == 0) {
				Location pl = player.getLocation();
				double x = pl.getX();
				double y = pl.getY();
				double z = pl.getZ();
				double yaw = pl.getYaw();
				double pitch = pl.getPitch();
				main.setLocationInConfig("Lobby", x, y, z, yaw, pitch);
				player.sendMessage(Utils.chat("&dLobby location setted."));
				return true;
			}
			else {
				player.sendMessage(Utils.chat("&cCouldnt set lobby location."));
				return false;
			}

		} catch (Exception e) {

			player.sendMessage(Utils.chat("&cCouldnt set lobby location. Error: " + e.getMessage()));
		}

		return true;
	}

}
