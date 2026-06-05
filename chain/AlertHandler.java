// Pattern: Chain of Responsibility
package com.sdapro.chain;

import com.sdapro.model.Alert;

public abstract class AlertHandler {

    protected AlertHandler nextHandler;

    public void setNextHandler(AlertHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(Alert alert);
}