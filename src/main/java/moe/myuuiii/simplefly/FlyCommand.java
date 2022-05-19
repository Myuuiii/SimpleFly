package moe.myuuiii.simplefly;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!sender.hasPermission(SimpleFly.FlyPermission)) {
			sender.sendMessage(SimpleFly.NoPermission);
			return false;
		}

		if (sender instanceof Player) {
			Player player = (Player) sender;
			Player targetPlayer = null;

			if (args.length == 1) {
				targetPlayer = Bukkit.getPlayer(args[0]);
				if (targetPlayer.getUniqueId().equals(player.getUniqueId())) {
					args = new String[] {};
				} else {
					if (!sender.hasPermission(SimpleFly.FlyForOthersPermission)) {
						sender.sendMessage(SimpleFly.NoPermissionForOthers);
						return false;
					}
				}
			}

			if (args.length == 0) {
				// Set flight for the player that executed the command.
				if (player.getAllowFlight()) {
					player.sendMessage(SimpleFly.Prefix + " Flight has been disabled");
					player.setAllowFlight(false);
				} else {
					player.sendMessage(SimpleFly.Prefix + " Flight has been enabled");
					player.setAllowFlight(true);
				}
			} else if (args.length == 1) {

				// Set flight for the targeted player, if they are online/exist
				if (targetPlayer.getAllowFlight()) {
					player.sendMessage(SimpleFly.Prefix + " Flight has been disabled for " + ChatColor.YELLOW
							+ targetPlayer.getName());
					targetPlayer.sendMessage(SimpleFly.Prefix + ChatColor.YELLOW + player.getName() + ChatColor.RESET
							+ " has disabled flight for you.");
					targetPlayer.setAllowFlight(false);
				} else {
					player.sendMessage(SimpleFly.Prefix + " Flight has been enabled for " + ChatColor.YELLOW
							+ targetPlayer.getName());
					targetPlayer
							.sendMessage(SimpleFly.Prefix + ChatColor.YELLOW + " " + player.getName() + ChatColor.RESET
									+ " has enabled flight for you.");
					targetPlayer.setAllowFlight(true);
				}
			}

		}
		return false;
	}

}
