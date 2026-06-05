// Pattern: Observer/Event Bus
package com.sdapro.eventbus;

public class DashboardUpdater
        implements EventSubscriber {

    @Override
    public void update(String event) {

        System.out.println(
                "[Dashboard] " + event);
    }
}