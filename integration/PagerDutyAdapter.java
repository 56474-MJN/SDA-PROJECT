// Pattern: Integration
package com.sdapro.integration;

public class PagerDutyAdapter
        implements SecurityPlatform {

    @Override
    public String execute(String data) {

        return "PagerDuty Alert Created: "
                + data;
    }
}