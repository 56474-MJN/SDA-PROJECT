// Pattern: Composite
package com.sdapro.composite;

import java.util.ArrayList;
import java.util.List;

public class AlertCampaign {

    private String campaignName;

    private List<SingleAlert> alerts =
            new ArrayList<>();

    public AlertCampaign(
            String campaignName) {

        this.campaignName =
                campaignName;
    }

    public void addAlert(
            SingleAlert alert) {

        alerts.add(alert);
    }

    public void displayCampaign() {

        System.out.println(
                "Campaign: "
                        + campaignName);

        for (SingleAlert alert : alerts) {

            alert.display();
        }
    }
}