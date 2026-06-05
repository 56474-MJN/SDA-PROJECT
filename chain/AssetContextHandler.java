// Pattern: Chain of Responsibility
package com.sdapro.chain;

import com.sdapro.model.Alert;

public class AssetContextHandler extends AlertHandler {

    @Override
    public void handle(Alert alert) {

        System.out.println(
                "Asset Context Enrichment Completed");

        if (nextHandler != null) {

            nextHandler.handle(alert);
        }
    }
}