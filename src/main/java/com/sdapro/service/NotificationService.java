// Pattern: Service Layer
package com.sdapro.service;

public class NotificationService {

    public String sendNotification(
            String message) {

        return "Notification Sent: "
                + message;
    }
}