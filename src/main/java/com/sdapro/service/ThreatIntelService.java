// Pattern: Service Layer
package com.sdapro.service;

public class ThreatIntelService {

    public String enrichAlert(
            String alert) {

        return "Threat Intelligence Added To: "
                + alert;
    }
}