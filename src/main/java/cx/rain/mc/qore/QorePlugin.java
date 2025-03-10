package cx.rain.mc.qore;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class QorePlugin extends JavaPlugin {
    private static QorePlugin Instance;

    private Logger logger;

    public QorePlugin() {
        if (Instance == null) {
            Instance = this;
        } else {
            throw new RuntimeException("Do NOT init me!");
        }

        logger = getLogger();

        logger.info("Loading.");
        new Qore();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        logger.info("Hello, also try IEconomy!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        logger.info("Goodbye!");
    }
}
