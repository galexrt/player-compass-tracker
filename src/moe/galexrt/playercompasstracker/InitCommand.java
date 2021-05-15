package moe.galexrt.playercompasstracker;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class InitCommand extends JavaPlugin {

    private final BukkitRunnable CompassTracker = new CompassTracker(this);

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        int refreshTime = this.getConfig().getInt("compass.refreshSeconds");
        this.CompassTracker.runTaskTimer(this, 1L, refreshTime);
    }

    @Override
    public void onDisable() {
        this.CompassTracker.cancel();
    }
}
