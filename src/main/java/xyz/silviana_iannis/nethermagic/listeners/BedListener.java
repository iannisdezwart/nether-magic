package xyz.silviana_iannis.nethermagic.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import xyz.silviana_iannis.nethermagic.NetherMagic;

public class BedListener implements Listener {

	private final NetherMagic main;

	public BedListener(NetherMagic main) {
		this.main = main;
	}

	@EventHandler
	public void onBedEnter(PlayerBedEnterEvent event) {
		Block bed = event.getBed();
		Player player = event.getPlayer();

		// Allow sleeping in the nether above the bedrock ceiling

		if (player.getWorld().getName().endsWith("_nether") && bed.getY() > 127) {
			event.setUseBed(Event.Result.ALLOW);
		}
	}
}
