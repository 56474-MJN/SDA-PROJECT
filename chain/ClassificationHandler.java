// Pattern: Chain of Responsibility
package com.sdapro.chain;

import com.sdapro.model.Alert;

public class ClassificationHandler extends AlertHandler {

    @Override
    public void handle(Alert alert) {

        System.out.println(
                "Alert Classification Completed");
    }
}