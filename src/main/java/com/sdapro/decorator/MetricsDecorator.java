// Pattern: Decorator
package com.sdapro.decorator;

public class MetricsDecorator
        extends ActionDecorator {

    public MetricsDecorator(Action action) {

        super(action);
    }

    @Override
    public void execute() {

        action.execute();

        System.out.println(
                "Metrics Recorded");
    }
}