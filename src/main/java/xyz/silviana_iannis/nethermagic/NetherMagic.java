package xyz.silviana_iannis.nethermagic;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.silviana_iannis.nethermagic.listeners.BedListener;
import xyz.silviana_iannis.nethermagic.listeners.WaterListener;

public final class NetherMagic extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();

		getServer().getPluginManager().registerEvents(new BedListener(this), this);
		getServer().getPluginManager().registerEvents(new WaterListener(this), this);
	}
}
