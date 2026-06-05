// Pattern: MVC Controller
package com.sdapro.controller;

import com.sdapro.models.IncidentQueueModel;
import com.sdapro.repository.IncidentRepository;

public class IncidentController {

    private IncidentQueueModel model;

    private IncidentRepository repository;

    public IncidentController(
            IncidentQueueModel model,
            IncidentRepository repository) {

        this.model = model;
        this.repository = repository;
    }

    public String createIncident() {

        String incident =
                "Incident Generated";

        model.addIncident(incident);

        repository.saveIncident(incident);

        return incident;
    }

    public int getIncidentCount() {

        return model.getIncidentCount();
    }

    public int getStoredIncidentCount() {

        return repository.countIncidents();
    }
}