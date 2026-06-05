// Pattern: Test - Decorator
package com.sdapro;

import com.sdapro.decorator.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {

    @Test
    void decoratorChainExists() {

        Action action =
                new MetricsDecorator(
                        new ApprovalDecorator(
                                new AuditDecorator(
                                        new BasicAction()
                                )
                        )
                );

        assertNotNull(action);
    }
}