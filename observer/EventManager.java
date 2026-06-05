// Pattern: Observer
package com.sdapro.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<Observer> observers =
            new ArrayList<>();

    public void subscribe(Observer observer) {

        observers.add(observer);
    }

    public void notifyObservers(String message) {

        for (Observer observer : observers) {

            observer.update(message);
        }
    }
}