// Pattern: Factory/Strategy
package com.sdapro.notification;

public class PagerDutyNotificationFactory
        implements NotificationFactory {

    @Override
    public Notifier createNotifier() {

        return new PagerDutyNotifier();
    }
}