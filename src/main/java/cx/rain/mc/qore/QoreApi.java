package cx.rain.mc.qore;

import org.bukkit.plugin.Plugin;

public class QoreApi {
    private final Plugin plugin;

    public QoreApi(Plugin pluginIn) {
        plugin = pluginIn;

        Qore.add(plugin, this);
    }

    public Plugin getPlugin() {
        return plugin;
    }


}
