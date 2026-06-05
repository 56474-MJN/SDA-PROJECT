// Pattern: Decorator
package com.sdapro.decorator;

public class RollbackDecorator
        extends ActionDecorator {

    public RollbackDecorator(Action action) {

        super(action);
    }

    @Override
    public void execute() {

        action.execute();

        System.out.println(
                "Rollback Point Created");
    }
}