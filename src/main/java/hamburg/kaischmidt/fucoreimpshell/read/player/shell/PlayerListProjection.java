package hamburg.kaischmidt.fucoreimpshell.read.player.shell;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PlayerListProjection {

    private Set<String> players = new HashSet<>();

    Set<String> getPlayers() {
        return players;
    }

    public void addNewPlayer(String playerName) {
        players.add(playerName);
    }
}
