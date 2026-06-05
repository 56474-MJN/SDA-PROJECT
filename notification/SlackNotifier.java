// Pattern: Factory/Strategy
package com.sdapro.notification;

public class SlackNotifier
        implements Notifier {

    @Override
    public void send(String message) {

        System.out.println(
                "Slack Notification: "
                        + message);
    }
}