package cx.rain.mc.qore.api.database;

import cx.rain.mc.qore.api.QoreApi;
import org.bukkit.plugin.Plugin;
import org.javalite.activejdbc.DB;
import org.javalite.activejdbc.RowListenerAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QoreDatabase {
    private final QoreApi api;
    private final Plugin plugin;

    private final HashMap<String, DB> databases = new HashMap<>();

    public QoreDatabase(QoreApi qoreIn) {
        api = qoreIn;
        plugin = api.getPlugin();
    }

    public DB open(String connectionName, String driver, String connectionString,
                   String username, String password) {
        DB db = new DB(connectionName).open(driver, connectionString, username, password);
        databases.put(db.name(), db);
        return db;
    }

    public DB open(String connectionName, DataSource source) {
        DB db = new DB(connectionName).open(source);
        databases.put(db.name(), db);
        return db;
    }

    public void loadModels(String modelName) {
        try {
            Class.forName(modelName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close(String connectionName) {
        if (databases.containsKey(connectionName)) {
            DB db = databases.get(connectionName);
            databases.remove(db.name());
            db.close();
        }
    }

    public QoreApi getApi() {
        return api;
    }

    public Plugin getPlugin() {
        return plugin;
    }
}
