// Pattern: Observer/Event Bus
package com.sdapro.eventbus;

import java.util.ArrayList;
import java.util.List;

public class EventBusPublisher {

    private static EventBusPublisher instance;

    private List<EventSubscriber> subscribers;

    private EventBusPublisher() {

        subscribers = new ArrayList<>();
    }

    public static EventBusPublisher getInstance() {

        if (instance == null) {

            instance =
                    new EventBusPublisher();
        }

        return instance;
    }

    public void subscribe(
            EventSubscriber subscriber) {

        subscribers.add(subscriber);
    }

    public void publish(String event) {

        for (EventSubscriber subscriber
                : subscribers) {

            subscriber.update(event);
        }
    }
}