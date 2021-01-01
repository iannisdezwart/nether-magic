package xyz.silviana_iannis.nethermagic.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import xyz.silviana_iannis.nethermagic.NetherMagic;

public class IceListener implements Listener {
	private final NetherMagic main;

	public IceListener(NetherMagic main) {
		main.getLogger().info(String.format("IceListener started listening"));
		this.main = main;
	}

	@EventHandler
	public void onBlockFromTo(BlockFadeEvent event) {
		Material oldMaterial = event.getBlock().getType();
		Material newMaterial = event.getNewState().getType();

		if (!(
			oldMaterial == Material.SNOW && newMaterial == Material.AIR
			|| oldMaterial == Material.ICE && newMaterial == Material.WATER
		)) return;

		if (pinkWoolUnderneath(event.getBlock())) {
			event.setCancelled(true);
		}
	}

	public boolean pinkWoolUnderneath(Block block) {
		Block currentBlock = block;

		while (currentBlock.getY() > 0) {
			currentBlock = currentBlock.getRelative(0, -1, 0);
			if (currentBlock.getType() == Material.PINK_WOOL) return true;
		}

		return false;
	}
}
