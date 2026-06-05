// Pattern: MVC Controller
package com.sdapro.controller;

import com.sdapro.models.DashboardMetricsModel;

public class DashboardController {

    private DashboardMetricsModel model;

    public DashboardController(
            DashboardMetricsModel model) {

        this.model = model;
    }

    public void recordAlert() {

        model.incrementAlerts();
    }

    public void recordIncident() {

        model.incrementIncidents();
    }

    public String getMetrics() {

        return "Alerts Processed: "
                + model.getAlertsProcessed()
                + "\nIncidents Created: "
                + model.getIncidentsCreated();
    }
}