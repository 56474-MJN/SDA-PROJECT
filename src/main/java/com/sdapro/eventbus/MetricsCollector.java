// Pattern: Observer/Event Bus
package com.sdapro.eventbus;

public class MetricsCollector
        implements EventSubscriber {

    @Override
    public void update(String event) {

        System.out.println(
                "[Metrics] " + event);
    }
}