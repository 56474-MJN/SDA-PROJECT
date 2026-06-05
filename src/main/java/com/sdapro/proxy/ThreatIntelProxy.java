// Pattern: Proxy
package com.sdapro.proxy;

import com.sdapro.adapter.MISPAdapter;
import com.sdapro.adapter.ThreatIntelService;
import com.sdapro.adapter.VirusTotalAdapter;

public class ThreatIntelProxy {

    private ThreatIntelService virusTotal;
    private ThreatIntelService misp;

    public ThreatIntelProxy() {

        virusTotal = new VirusTotalAdapter();
        misp = new MISPAdapter();
    }

    public void fetchThreatData(String ip) {

        System.out.println(
                "Proxy: Checking Cache");

        System.out.println(
                virusTotal.getThreatInfo(ip));

        System.out.println(
                misp.getThreatInfo(ip));
    }
}