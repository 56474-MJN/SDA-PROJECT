// Pattern: Chain of Responsibility
package com.sdapro.chain;

import com.sdapro.model.Alert;

public class GeoIPHandler extends AlertHandler {

    @Override
    public void handle(Alert alert) {

        System.out.println(
                "GeoIP Enrichment Completed");

        if (nextHandler != null) {
            nextHandler.handle(alert);
        }
    }
}