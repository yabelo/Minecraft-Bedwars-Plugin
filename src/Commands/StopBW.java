package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Classes.Server;
import Main.Main;

public class StopBW implements CommandExecutor {

	public Main main;

	public StopBW(Main main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player))
			return false;

		Player player = (Player) sender;
		if (player.isOp())
			Server.stopGame();

		return true;
	}

}
