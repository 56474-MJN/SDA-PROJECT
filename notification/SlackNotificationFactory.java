// Pattern: Factory/Strategy
package com.sdapro.notification;

public class SlackNotificationFactory
        implements NotificationFactory {

    @Override
    public Notifier createNotifier() {

        return new SlackNotifier();
    }
}