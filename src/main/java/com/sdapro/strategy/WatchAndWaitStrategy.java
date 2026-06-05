// Pattern: Strategy
package com.sdapro.strategy;

public class WatchAndWaitStrategy
        implements ResponseStrategy {

    @Override
    public void executeResponse() {

        System.out.println(
                "Monitoring threat activity and collecting evidence");
    }
}