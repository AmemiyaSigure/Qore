package cx.rain.mc.qore.api.config;

import cx.rain.mc.qore.api.QoreApi;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class YamlConfig extends YamlConfiguration {
    protected final String name;

    protected QoreApi api;
    protected QoreConfig manager;
    protected Plugin owner;
    protected File configFile;

    private String nameInJar;
    private String pathInJar;

    public YamlConfig(QoreApi apiIn, String nameIn, String pathIn) {
        this(apiIn, nameIn, pathIn, nameIn, pathIn, false);
    }

    public YamlConfig(QoreApi apiIn, String nameIn, String pathIn, String nameInJarIn, String pathInJarIn) {
        this(apiIn, nameIn, pathIn, nameInJarIn, pathInJarIn, false);
    }

    public YamlConfig(QoreApi apiIn, String nameIn, String pathIn, String nameInJarIn, String pathInJarIn, boolean overwrite) {
        api = apiIn;
        manager = api.getConfig();
        owner = api.getPlugin();

        name = nameIn;
        if (!nameIn.isEmpty() && !pathIn.isEmpty()) {
            configFile = new File(pathIn, nameIn + ".yml");
        }

        nameInJar = nameInJarIn;
        pathInJar = pathInJarIn;

        if (overwrite && configFile.exists()) {
            if (!configFile.delete()) {
                Bukkit.getLogger().warning("Cannot remove configuration of plugin " + api.getPlugin().getName() +
                        " for overwriting. " +
                        "File: " + configFile.getPath() + " . " +
                        "There may be something wrong, but you can continue use this plugin.");
            }
        }

        if (!configFile.exists()) {
            init(true);
        } else {
            load();
        }
    }

    public void init(boolean isNewFile) {
        if (isNewFile) {
            firstLoad();
            initFile();
        }
        beforeLoad();
        load();
    }

    public void initFile() {
        try {
            configFile.getParentFile().mkdirs();
            configFile.createNewFile();
        } catch (IOException ex) {
            Bukkit.getLogger().warning("Error while creating file: " + configFile.getPath() + " of plugin " +
                    api.getPlugin().getName() + ". " +
                    "Caused by: " + ex);
        }

        loadFileInJar();

        reload();
    }

    public void load() {
        try {
            load(configFile);
        } catch (IOException | InvalidConfigurationException ex) {
            ex.printStackTrace();
        }
    }

    public void loadFileInJar() {
        options().copyDefaults(true);

        String path = "";
        if (!pathInJar.isEmpty()) {
            path += pathInJar + "/";
        }
        if (nameInJar.isEmpty()) {
            path += getName();
        } else {
            path += nameInJar;
        }
        path += ".yml";

        try {
            InputStream is = owner.getResource(path);
            if (is != null) {
                Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
                YamlConfiguration defaults = YamlConfiguration.loadConfiguration(reader);
                options().header(defaults.options().header());
                setDefaults(defaults);

                reader.close();
                is.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        reload();
    }

    public void reload() {
        reload(false);
    }

    public void reload(boolean shouldSave) {
        if (shouldSave) {
            save();
        }
        load();
    }

    public void save() {
        try {
            save(configFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void firstLoad() {

    }

    protected void beforeLoad() {

    }
}
