// Pattern: Test - Composite
package com.sdapro;

import com.sdapro.composite.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompositeTest {

    @Test
    void responsePlanCreated() {

        ResponsePlan plan =
                new ResponsePlan();

        assertNotNull(plan);
    }
}