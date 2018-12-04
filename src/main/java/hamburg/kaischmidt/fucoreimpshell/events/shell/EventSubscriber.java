package hamburg.kaischmidt.fucoreimpshell.events.shell;

import hamburg.kaischmidt.fucoreimpshell.events.core.DomainEvent;

public interface EventSubscriber {

    void updateProjections(DomainEvent event);

}
