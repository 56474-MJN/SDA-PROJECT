// Pattern: Strategy
package com.sdapro.strategy;

public class BalancedStrategy implements ResponseStrategy {

    @Override
    public void executeResponse() {

        System.out.println(
                "Executing Balanced Response");

        System.out.println(
                "Generating Alert");

        System.out.println(
                "Monitoring Activity");
    }
}