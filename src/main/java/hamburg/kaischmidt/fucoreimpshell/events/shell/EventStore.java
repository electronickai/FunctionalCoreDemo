package hamburg.kaischmidt.fucoreimpshell.events.shell;

import hamburg.kaischmidt.fucoreimpshell.events.core.PlayerCreatedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventStore {

    private List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }

    public void addPlayerCreatedEvent(PlayerCreatedEvent domainEvent) {
        var event = new Event();
        event.setDomainEvent(domainEvent);
        events.add(event);
    }
}
