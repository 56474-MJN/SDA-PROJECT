// Pattern: Strategy (Normalizer)
package com.sdapro.normalizer;

public class CrowdStrikeNormalizer
        implements AlertNormalizer {

    @Override
    public void normalize() {

        System.out.println(
                "CrowdStrike Alert Normalized");
    }
}