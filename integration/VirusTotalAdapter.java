// Pattern: Integration
package com.sdapro.integration;

public class VirusTotalAdapter
        implements SecurityPlatform {

    @Override
    public String execute(String data) {

        return "VirusTotal Analysis: "
                + data;
    }
}