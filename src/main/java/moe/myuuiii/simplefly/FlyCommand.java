package moe.myuuiii.simplefly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.getAllowFlight()) {
				player.sendMessage(SimpleFly.Prefix + " Flight has been disabled");
				player.setAllowFlight(false);
			} else {
				player.sendMessage(SimpleFly.Prefix + " Flight has been enabled");
				player.setAllowFlight(true);
			}
		}
		return false;
	}

}
