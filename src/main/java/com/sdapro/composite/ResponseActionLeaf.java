// Pattern: Composite
package com.sdapro.composite;

public class ResponseActionLeaf
        implements ResponseComponent {

    private String actionName;

    public ResponseActionLeaf(String actionName) {

        this.actionName = actionName;
    }

    @Override
    public void execute() {

        System.out.println(
                "Executing: " + actionName);
    }
}