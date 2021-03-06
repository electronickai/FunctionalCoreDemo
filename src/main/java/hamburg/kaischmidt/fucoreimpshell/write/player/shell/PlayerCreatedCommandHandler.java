package hamburg.kaischmidt.fucoreimpshell.write.player.shell;

import hamburg.kaischmidt.fucoreimpshell.events.shell.EventStore;
import hamburg.kaischmidt.fucoreimpshell.write.player.core.PlayerAggregate;
import org.springframework.stereotype.Component;

@Component
public class PlayerCreatedCommandHandler {

    private final EventStore store;
    private final PlayerAggregate player;

    public PlayerCreatedCommandHandler(EventStore store, PlayerAggregate player) {
        this.store = store;
        this.player = player;
    }

    void handle(PlayerCreatedCommand command) {
        var playerCreatedEvent = player.create(command.getPlayerName());
        store.addPlayerCreatedEvent(playerCreatedEvent);
    }
}
