package hamburg.kaischmidt.fucoreimpshell.update;

import hamburg.kaischmidt.fucoreimpshell.events.core.DomainEvent;
import hamburg.kaischmidt.fucoreimpshell.events.core.PlayerCreatedEvent;
import hamburg.kaischmidt.fucoreimpshell.events.shell.EventSubscriber;
import hamburg.kaischmidt.fucoreimpshell.read.player.shell.PlayerListProjection;
import org.springframework.stereotype.Component;

@Component
public class ProjectionUpdater implements EventSubscriber {

    private PlayerListProjection playerListProjection;

    public ProjectionUpdater(PlayerListProjection playerListProjection) {
        this.playerListProjection = playerListProjection;
    }

    @Override
    public void updateProjections(DomainEvent event) {
        if (event instanceof PlayerCreatedEvent) {
            playerListProjection.addNewPlayer(((PlayerCreatedEvent) event).getPlayerName());
        }
    }
}
