// Pattern: Service Layer
package com.sdapro.service;

import com.sdapro.model.Alert;
import com.sdapro.model.Incident;

public class IncidentService {

    public Incident createIncident(Alert alert) {

        Incident incident = new Incident();

        incident.setIncidentId(alert.getId());
        incident.setAlert(alert);
        incident.setState("NEW");

        return incident;
    }
}