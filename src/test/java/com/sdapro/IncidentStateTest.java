// Pattern: Test - State
package com.sdapro;

import com.sdapro.state.IncidentContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IncidentStateTest {

    @Test
    public void stateTransitionTest() {

        IncidentContext context =
                new IncidentContext();

        assertNotNull(
                context.getState());

        context.nextState();

        assertNotNull(
                context.getState());
    }
}
