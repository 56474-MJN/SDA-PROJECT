// Pattern: Observer/Event Bus
package com.sdapro.eventbus;

public class AuditEventLogger
        implements EventSubscriber {

    @Override
    public void update(String event) {

        System.out.println(
                "[Audit Log] " + event);
    }
}