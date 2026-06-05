// Pattern: MVC Model
package com.sdapro.models;

import java.util.ArrayList;
import java.util.List;

public class IncidentQueueModel {

    private List<String> incidents =
            new ArrayList<>();

    public void addIncident(String incident) {

        incidents.add(incident);
    }

    public List<String> getIncidents() {

        return incidents;
    }

    public int getIncidentCount() {

        return incidents.size();
    }
}