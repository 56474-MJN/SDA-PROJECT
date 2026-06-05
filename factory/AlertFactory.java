// Pattern: Factory
package com.sdapro.factory;

import com.sdapro.model.Alert;

public class AlertFactory {

    public static Alert createAlert(
            int id,
            String source,
            String severity,
            String description) {

        return new Alert(
                id,
                source,
                severity,
                description
        );
    }
}