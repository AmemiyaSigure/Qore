package cx.rain.mc.qore.utility;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class QScoreBoard {
    private final String name;
    private final Scoreboard board;

    public QScoreBoard(String nameIn) {
        name = nameIn;
        board = Bukkit.getScoreboardManager().getNewScoreboard();
    }

    public QScoreBoard(String nameIn, Scoreboard boardIn) {
        name = nameIn;
        board = boardIn;
    }

    public Scoreboard getBoard() {
        return board;
    }

    public void showFor(Player player) {
        player.setScoreboard(board);
    }

    public void show() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.setScoreboard(board);
        });
    }

    public void
}
