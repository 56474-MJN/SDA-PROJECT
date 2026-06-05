// Pattern: Factory/Strategy
package com.sdapro.notification;

public interface NotificationFactory {

    Notifier createNotifier();
}