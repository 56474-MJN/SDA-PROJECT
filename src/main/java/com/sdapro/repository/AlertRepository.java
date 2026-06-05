// Pattern: Repository
package com.sdapro.repository;

import java.util.ArrayList;
import java.util.List;

public class AlertRepository {

    private List<String> alerts =
            new ArrayList<>();

    public void saveAlert(
            String alert) {

        alerts.add(alert);
    }

    public List<String> findAllAlerts() {

        return alerts;
    }

    public int countAlerts() {

        return alerts.size();
    }

    public String getLatestAlert() {

        if (alerts.isEmpty()) {

            return "No Alert Available";
        }

        return alerts.get(
                alerts.size() - 1);
    }
}