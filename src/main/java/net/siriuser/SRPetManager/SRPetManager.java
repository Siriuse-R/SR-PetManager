package net.siriuser.SRPetManager;

import java.io.IOException;
import java.util.logging.Logger;

import net.siriuser.SRPetManager.listeners.PlayerListener;
import net.syamn.utils.Metrics;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SRPetManager extends JavaPlugin {
    public final static Logger log = Logger.getLogger("Minecraft");
    public final static String logPrefix = "[SRPM] ";

    @Override
    public void onEnable() {

        // イベントリスナー登録
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(this), this);

        // SR-CoreLibが無ければプラグインを停止
        if (!getServer().getPluginManager().isPluginEnabled("SR-CoreLib")) {
            log.warning(logPrefix + "SR-CoreLib is not enabled!");
            pm.disablePlugin(this);
            return;
        }

        setupMetrics();

        PluginDescriptionFile pdfFile = this.getDescription();
        log.info("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + " is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);

        PluginDescriptionFile pdfFile = this.getDescription();
        log.info("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + "is disabled!");
    }

    private void setupMetrics() {
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            log.warning(logPrefix + "Metrics Error");
        }
    }
}
