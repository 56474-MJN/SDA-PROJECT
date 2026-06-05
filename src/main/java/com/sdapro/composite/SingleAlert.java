// Pattern: Composite
package com.sdapro.composite;

public class SingleAlert {

    private String alertName;

    public SingleAlert(
            String alertName) {

        this.alertName = alertName;
    }

    public void display() {

        System.out.println(
                "Alert: " + alertName);
    }

    public String getAlertName() {

        return alertName;
    }
}