// Pattern: Strategy (Normalizer)
package com.sdapro.normalizer;

public class SplunkNormalizer
        implements AlertNormalizer {

    @Override
    public void normalize() {

        System.out.println(
                "Splunk Alert Normalized");
    }
}