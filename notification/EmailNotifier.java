// Pattern: Factory/Strategy
package com.sdapro.notification;

public class EmailNotifier
        implements Notifier {

    @Override
    public void send(String message) {

        System.out.println(
                "Email Notification: "
                        + message);
    }
}