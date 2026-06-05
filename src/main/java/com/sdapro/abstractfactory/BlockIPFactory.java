// Pattern: Abstract Factory
package com.sdapro.abstractfactory;

public class BlockIPFactory
        implements ResponseFactory {

    @Override
    public ResponseAction createAction() {

        return new BlockIPAction();
    }
}