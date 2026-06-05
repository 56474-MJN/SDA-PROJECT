// Pattern: Strategy
package com.sdapro.strategy;

public class AggressiveStrategy implements ResponseStrategy {

    @Override
    public void executeResponse() {

        System.out.println(
                "Executing Aggressive Response");

        System.out.println(
                "Blocking IP");

        System.out.println(
                "Isolating Endpoint");
    }
}
