// Pattern: Strategy (Normalizer)
package com.sdapro.normalizer;

public class FirewallNormalizer
        implements AlertNormalizer {

    @Override
    public void normalize() {

        System.out.println(
                "Firewall Alert Normalized");
    }
}