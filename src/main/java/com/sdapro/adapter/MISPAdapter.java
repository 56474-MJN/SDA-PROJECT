// Pattern: Adapter
package com.sdapro.adapter;

public class MISPAdapter
        implements ThreatIntelService {

    @Override
    public String getThreatInfo(String ip) {

        return "MISP Result: "
                + ip
                + " found in threat feed";
    }
}