// Pattern: MVC Model
package com.sdapro.models;

import java.util.ArrayList;
import java.util.List;

public class AlertStreamModel {

    private List<String> alerts =
            new ArrayList<>();

    public void addAlert(String alert) {

        alerts.add(alert);
    }

    public List<String> getAlerts() {

        return alerts;
    }

    public int getAlertCount() {

        return alerts.size();
    }
}