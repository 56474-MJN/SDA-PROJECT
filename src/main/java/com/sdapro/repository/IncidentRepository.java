// Pattern: Repository
package com.sdapro.repository;

import java.util.ArrayList;
import java.util.List;

public class IncidentRepository {

    private List<String> incidents =
            new ArrayList<>();

    public void saveIncident(
            String incident) {

        incidents.add(incident);
    }

    public List<String> findAllIncidents() {

        return incidents;
    }

    public int countIncidents() {

        return incidents.size();
    }

    public String getLatestIncident() {

        if (incidents.isEmpty()) {

            return "No Incident Available";
        }

        return incidents.get(
                incidents.size() - 1);
    }
}