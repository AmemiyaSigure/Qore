package cx.rain.mc.qore.api.database;

import cx.rain.mc.qore.api.QoreApi;
import org.bukkit.plugin.Plugin;

public class QoreDatabase {
    private final QoreApi api;
    private final Plugin plugin;

    public QoreDatabase(QoreApi qoreIn) {
        api = qoreIn;
        plugin = api.getPlugin();
    }

    
}
