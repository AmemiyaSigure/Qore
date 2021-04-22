package cx.rain.mc.qore.api.config;

import cx.rain.mc.qore.api.QoreApi;
import org.bukkit.plugin.Plugin;

public class QoreConfig {
    private final QoreApi api;
    private final Plugin plugin;

    public QoreConfig(QoreApi qoreIn) {
        api = qoreIn;
        plugin = api.getPlugin();
    }

    public QoreApi getApi() {
        return api;
    }

    public Plugin getPlugin() {
        return plugin;
    }
}
