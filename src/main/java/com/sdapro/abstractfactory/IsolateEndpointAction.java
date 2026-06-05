// Pattern: Abstract Factory
package com.sdapro.abstractfactory;

public class IsolateEndpointAction
        implements ResponseAction {

    @Override
    public void execute() {

        System.out.println(
                "Isolating Endpoint");
    }
}