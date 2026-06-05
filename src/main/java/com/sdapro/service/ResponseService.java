// Pattern: Service Layer
package com.sdapro.service;

import com.sdapro.strategy.*;

public class ResponseService {

   public ResponseStrategy chooseStrategy(
        String severity) {

    if (severity.equalsIgnoreCase("Critical")) {

        return new AggressiveStrategy();
    }

    if (severity.equalsIgnoreCase("High")) {

        return new BalancedStrategy();
    }

    if (severity.equalsIgnoreCase("Medium")) {

        return new ConservativeStrategy();
    }

    return new WatchAndWaitStrategy();
}
}