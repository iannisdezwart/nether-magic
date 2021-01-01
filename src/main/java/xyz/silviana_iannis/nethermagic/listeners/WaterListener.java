package xyz.silviana_iannis.nethermagic.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.Action;
import org.bukkit.GameMode;
import org.bukkit.Material;
import xyz.silviana_iannis.nethermagic.NetherMagic;

public class WaterListener implements Listener {
	private final NetherMagic main;

	public WaterListener(NetherMagic main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		ItemStack usedItem = event.getItem();
		if (usedItem == null || usedItem.getType() != Material.WATER_BUCKET) return;

		Player player = event.getPlayer();
		Block clickedBlock = event.getClickedBlock();
		if (clickedBlock == null) return;

		Block selectedBlock = clickedBlock.getRelative(event.getBlockFace());

		// Cancel water removal when water is placed above the nether ceiling

		if (!(
			event.getAction() == Action.RIGHT_CLICK_BLOCK
			&& usedItem != null && usedItem.getType() == Material.WATER_BUCKET
			&& player.getWorld().getName().endsWith("_nether")
			&& selectedBlock.getY() > 127
		)) return;

		event.setCancelled(true);

		// Add water block

		selectedBlock.setType(Material.WATER);

		// Remove bucket

		if (player.getGameMode() != GameMode.CREATIVE) {
			event.getItem().setType(Material.BUCKET);
		}
	}
}
