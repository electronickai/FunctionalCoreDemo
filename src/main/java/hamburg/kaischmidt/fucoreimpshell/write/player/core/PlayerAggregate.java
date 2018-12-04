package hamburg.kaischmidt.fucoreimpshell.write.player.core;

import hamburg.kaischmidt.fucoreimpshell.events.core.PlayerCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class PlayerAggregate {

    public PlayerCreatedEvent create(String playerName) {
        return new PlayerCreatedEvent(playerName);
    }

}
