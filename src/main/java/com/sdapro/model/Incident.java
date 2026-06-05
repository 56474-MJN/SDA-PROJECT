// Pattern: MVC Model
package com.sdapro.model;

public class Incident {

    private int incidentId;
    private Alert alert;
    private String state;

    public Incident() {
    }

    public Incident(int incidentId, Alert alert, String state) {
        this.incidentId = incidentId;
        this.alert = alert;
        this.state = state;
    }

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}