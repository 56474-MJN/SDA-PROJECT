// Pattern: Factory/Strategy
package com.sdapro.notification;

public class PagerDutyNotifier
        implements Notifier {

    @Override
    public void send(String message) {

        System.out.println(
                "PagerDuty Notification: "
                        + message);
    }
}