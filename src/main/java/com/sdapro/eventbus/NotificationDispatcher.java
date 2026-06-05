// Pattern: Observer/Event Bus
package com.sdapro.eventbus;

public class NotificationDispatcher
        implements EventSubscriber {

    @Override
    public void update(String event) {

        System.out.println(
                "[Notification] " + event);
    }
}