package cx.rain.mc.qore.status;

import com.google.common.collect.BiMap;
import cx.rain.mc.qore.utility.QScoreBoard;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QoreStatus {
    protected static Map<Plugin, BiMap<String, QScoreBoard>> Boards = new HashMap<>();

}
