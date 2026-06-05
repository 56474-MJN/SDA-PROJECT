// Pattern: Adapter
package com.sdapro.adapter;

public class VirusTotalAdapter
        implements ThreatIntelService {

    @Override
    public String getThreatInfo(String ip) {

        return "VirusTotal Result: "
                + ip
                + " flagged as suspicious";
    }
}