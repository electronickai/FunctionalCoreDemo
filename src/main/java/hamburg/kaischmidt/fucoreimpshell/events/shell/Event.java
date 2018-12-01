package hamburg.kaischmidt.fucoreimpshell.events.shell;

import hamburg.kaischmidt.fucoreimpshell.events.core.DomainEvent;

import java.time.LocalDateTime;

public class Event {

    private DomainEvent domainEvent;
    private LocalDateTime createdTime;

    Event() {
        createdTime = LocalDateTime.now();
    }

    void setDomainEvent(DomainEvent domainEvent) {
        this.domainEvent = domainEvent;
    }

    public DomainEvent getDomainEvent() {
        return domainEvent;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
