// Pattern: Observer
package com.sdapro.observer;

public class NotificationObserver implements Observer {

    @Override
    public void update(String message) {

        System.out.println(
                "[Notification] " + message);
    }
}