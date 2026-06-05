// Pattern: Integration
package com.sdapro.integration;

public class SlackAdapter
        implements SecurityPlatform {

    @Override
    public String execute(String data) {

        return "Slack Notification Sent: "
                + data;
    }
}