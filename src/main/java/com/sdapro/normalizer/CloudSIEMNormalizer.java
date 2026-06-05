// Pattern: Strategy (Normalizer)
package com.sdapro.normalizer;

public class CloudSIEMNormalizer
        implements AlertNormalizer {

    @Override
    public void normalize() {

        System.out.println(
                "Cloud SIEM Alert Normalized");
    }
}