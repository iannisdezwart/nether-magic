package xyz.silviana_iannis.nethermagic;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.silviana_iannis.nethermagic.listeners.BedListener;

public final class NetherMagic extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();

		getServer().getPluginManager().registerEvents(new BedListener(this), this);
	}
}
