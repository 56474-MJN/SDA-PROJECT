// Pattern: Strategy (Normalizer)
package com.sdapro.normalizer;

public class AlertNormalizerFactory {

    public static AlertNormalizer
    createNormalizer(String source) {

        switch (source.toLowerCase()) {

            case "splunk":
                return new SplunkNormalizer();

            case "crowdstrike":
                return new CrowdStrikeNormalizer();

            case "firewall":
                return new FirewallNormalizer();

            case "cloudsiem":
                return new CloudSIEMNormalizer();

            default:
                throw new IllegalArgumentException(
                        "Unknown Source");
        }
    }
}