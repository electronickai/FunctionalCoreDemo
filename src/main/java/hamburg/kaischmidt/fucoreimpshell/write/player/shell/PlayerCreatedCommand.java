package hamburg.kaischmidt.fucoreimpshell.write.player.shell;

class PlayerCreatedCommand {

    private String playerName;

    PlayerCreatedCommand(String playerName) {
        this.playerName = playerName;
    }

    String getPlayerName() {
        return playerName;
    }

}
