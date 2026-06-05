// Pattern: Observer/Event Bus
package com.sdapro.eventbus;

public interface EventSubscriber {

    void update(String event);
}