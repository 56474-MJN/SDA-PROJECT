// Pattern: Service Layer
package com.sdapro.service;

public class AuditService {

    public String logEvent(
            String event) {

        return "Audit Logged: "
                + event;
    }
}