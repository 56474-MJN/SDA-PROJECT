// Pattern: Factory/Strategy
package com.sdapro.notification;

public class EmailNotificationFactory
        implements NotificationFactory {

    @Override
    public Notifier createNotifier() {

        return new EmailNotifier();
    }
}