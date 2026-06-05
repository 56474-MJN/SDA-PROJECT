// Pattern: Test - Facade
package com.sdapro;

import com.sdapro.facade.IncidentResponseFacade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FacadeTest {

    @Test
    void facadeCreated() {

        IncidentResponseFacade facade =
                new IncidentResponseFacade();

        assertNotNull(facade);
    }
}