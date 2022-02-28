package cx.rain.mc.qore.api.config;

import cx.rain.mc.qore.api.QoreApi;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

@Deprecated
public class QoreConfig {
    private final QoreApi api;
    private final Plugin plugin;

    private final HashMap<String, YamlConfig> configs = new HashMap<>();

    public QoreConfig(QoreApi qoreIn) {
        api = qoreIn;
        plugin = api.getPlugin();
    }

    public YamlConfig getConfig(String name, String path) {
        String key = path + "/" + name;

        if (configs.containsKey(key)) {
            return configs.get(key);
        } else {
            return createConfig(name, path);
        }
    }

    public YamlConfig createConfig(String name, String path) {
        return createConfig(name, path, "", "");
    }

    public YamlConfig createConfig(String name, String path, String nameInJar, String pathInJar) {
        return createConfig(name, path, nameInJar, pathInJar, false);
    }

    public YamlConfig createConfig(String name, String path, String nameInJar, String pathInJar, boolean overwrite) {
        YamlConfig config = new YamlConfig(api, name, path, nameInJar, pathInJar, overwrite);
        configs.put(config.getName(), config);
        return config;
    }

    public void registerConfig(YamlConfig config) {
        configs.put(config.getName(), config);
    }

    public QoreApi getApi() {
        return api;
    }

    public Plugin getPlugin() {
        return plugin;
    }
}
