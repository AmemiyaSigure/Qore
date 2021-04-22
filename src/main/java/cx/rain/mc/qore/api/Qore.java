package cx.rain.mc.qore.api;

import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

// Qore manager class.
public class Qore {
    private static Qore Instance;

    private static Map<Plugin, QoreApi> Plugins = new HashMap<>();

    public Qore() {
        if (Instance == null) {
            Instance = this;
        } else {
            throw new RuntimeException("Why init me twice? Use getInstance() plz.");
        }
    }

    public static Qore getInstance() {
        if (Instance == null) {
            throw new RuntimeException("I guess you have not written Qore to dependency of your plugin yet.");
        }

        return Instance;
    }

    public static QoreApi getApiByPlugin(Plugin plugin) {
        if (!has(plugin)) {
            new QoreApi(plugin);
        }

        return get(plugin);
    }

    private static boolean has(Plugin plugin) {
        return Plugins.containsKey(plugin);
    }

    private static QoreApi get(Plugin plugin) {
        return Plugins.get(plugin);
    }

    protected static void add(Plugin plugin, QoreApi api) {
        if (!has(plugin)) {
            Plugins.put(plugin, api);
        }
    }
}
