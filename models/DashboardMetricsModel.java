// Pattern: MVC Model
package com.sdapro.models;

public class DashboardMetricsModel {

    private int alertsProcessed;

    private int incidentsCreated;

    public void incrementAlerts() {

        alertsProcessed++;
    }

    public void incrementIncidents() {

        incidentsCreated++;
    }

    public int getAlertsProcessed() {

        return alertsProcessed;
    }

    public int getIncidentsCreated() {

        return incidentsCreated;
    }
}