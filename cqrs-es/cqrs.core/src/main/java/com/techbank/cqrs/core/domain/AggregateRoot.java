package com.techbank.cqrs.core.domain;

import com.techbank.cqrs.core.events.BaseEvent;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AggregateRoot {
    private String id ;
    private int version = -1 ;
    private final List<BaseEvent> changes = new ArrayList<>() ;

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<BaseEvent> getUncommittedChanges() {
        return this.changes ;
    }

    public void markChangesAsCommitted() {
        this.changes.clear();
    }

    protected void applyChange(BaseEvent event, Boolean isNewEvent) {
        try {
            var method = getClass().getMethod("apply", event.getClass()) ;
            method.setAccessible(true);
            method.invoke(this, event) ;
        } catch (NoSuchMethodException e) {
            log.warn("The apply method is not found in aggregate for {}", event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            log.error("Error applying event to aggregate");
            throw new RuntimeException(e);
        }
    }
}
