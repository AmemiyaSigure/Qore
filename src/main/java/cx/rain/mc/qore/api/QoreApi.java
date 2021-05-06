package cx.rain.mc.qore.api;

import cx.rain.mc.qore.api.config.QoreConfig;
import org.bukkit.plugin.Plugin;

public class QoreApi {
    private final Plugin plugin;

    private QoreConfig config;

    public QoreApi(Plugin pluginIn) {
        plugin = pluginIn;
        config = new QoreConfig(this);

        Qore.add(plugin, this);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public QoreConfig getConfig() {
        return config;
    }
}
