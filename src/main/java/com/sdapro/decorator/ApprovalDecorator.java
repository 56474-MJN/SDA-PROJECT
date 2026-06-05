// Pattern: Decorator
package com.sdapro.decorator;

public class ApprovalDecorator
        extends ActionDecorator {

    public ApprovalDecorator(Action action) {

        super(action);
    }

    @Override
    public void execute() {

        action.execute();

        System.out.println(
                "Manager Approval Added");
    }
}