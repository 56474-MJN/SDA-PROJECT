// Pattern: Service Layer
package com.sdapro.service;

public class AlertIngestionService {

    public String ingestAlert(
            String source) {

        return "Alert Ingested From: "
                + source;
    }
}