// Pattern: Decorator
package com.sdapro.decorator;

public abstract class ActionDecorator
        implements Action {

    protected Action action;

    public ActionDecorator(Action action) {

        this.action = action;
    }
}