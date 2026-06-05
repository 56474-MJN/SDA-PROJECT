// Pattern: Test - Strategy
package com.sdapro;

import com.sdapro.service.ResponseService;
import com.sdapro.strategy.ResponseStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResponseStrategyTest {

    @Test
    public void strategySelectionTest() {

        ResponseService service =
                new ResponseService();

        ResponseStrategy strategy =
                service.chooseStrategy(
                        "Critical");

        assertNotNull(strategy);
    }
}