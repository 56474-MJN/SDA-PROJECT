// Pattern: Chain of Responsibility
package com.sdapro.chain;

import com.sdapro.model.Alert;

public class DeduplicationHandler extends AlertHandler {

    @Override
    public void handle(Alert alert) {

        System.out.println(
                "Deduplication Check Completed");

        if (nextHandler != null) {
            nextHandler.handle(alert);
        }
    }
}