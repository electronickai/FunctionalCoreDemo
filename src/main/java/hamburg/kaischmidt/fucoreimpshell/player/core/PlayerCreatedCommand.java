package hamburg.kaischmidt.fucoreimpshell.player.core;

public class PlayerCreatedCommand {

    private String playerName;

    public PlayerCreatedCommand(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

}
