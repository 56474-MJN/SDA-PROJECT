// Pattern: Strategy
package com.sdapro.strategy;

public class ConservativeStrategy implements ResponseStrategy {

    @Override
    public void executeResponse() {

        System.out.println(
                "Executing Conservative Response");

        System.out.println(
                "Logging Event");

        System.out.println(
                "Waiting For Analyst Review");
    }
}