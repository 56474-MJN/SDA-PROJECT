// Pattern: Integration
package com.sdapro.integration;

public class MISPAdapter
        implements SecurityPlatform {

    @Override
    public String execute(String data) {

        return "MISP Threat Intelligence: "
                + data;
    }
}