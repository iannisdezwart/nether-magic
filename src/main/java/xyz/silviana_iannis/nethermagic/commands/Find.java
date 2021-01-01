package xyz.silviana_iannis.nethermagic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Material;
import xyz.silviana_iannis.nethermagic.NetherMagic;

public class Find implements CommandExecutor {
	private final NetherMagic main;

	public Find(NetherMagic main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(
		CommandSender sender,
		Command command,
		String label,
		String[] args
	) {
		if (args.length < 1) {
			sender.sendMessage("Usage: /find <block> [dist_x] [dist_y] [dist_z]");
			return true;
		}

		Material block = Material.getMaterial(args[0]);
		if (block == null) {
			sender.sendMessage("Material not found");
			return true;
		}

		return true;
	}
}