// Pattern: Decorator
package com.sdapro.decorator;

public class AuditDecorator
        extends ActionDecorator {

    public AuditDecorator(Action action) {

        super(action);
    }

    @Override
    public void execute() {

        action.execute();

        System.out.println(
                "Audit Log Recorded");
    }
}