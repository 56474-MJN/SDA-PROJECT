// Pattern: Abstract Factory
package com.sdapro.abstractfactory;

public class IsolateEndpointFactory
        implements ResponseFactory {

    @Override
    public ResponseAction createAction() {

        return new IsolateEndpointAction();
    }
}