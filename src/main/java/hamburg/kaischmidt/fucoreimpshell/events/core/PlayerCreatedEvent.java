package hamburg.kaischmidt.fucoreimpshell.events.core;

public class PlayerCreatedEvent implements DomainEvent {

    private String playerName;

    public PlayerCreatedEvent(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
