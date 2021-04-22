package cx.rain.mc.qore.api;

import cx.rain.mc.qore.api.config.QoreConfig;
import cx.rain.mc.qore.api.database.QoreDatabase;
import org.bukkit.plugin.Plugin;

public class QoreApi {
    private final Plugin plugin;

    private QoreConfig config;
    private QoreDatabase database;

    public QoreApi(Plugin pluginIn) {
        plugin = pluginIn;
        config = new QoreConfig(this);
        database = new QoreDatabase(this);

        Qore.add(plugin, this);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public QoreConfig getConfig() {
        return config;
    }

    public QoreDatabase getDatabase() {
        return database;
    }
}
