// Pattern: Test - Factory
package com.sdapro;

import com.sdapro.factory.AlertFactory;
import com.sdapro.model.Alert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlertFactoryTest {

    @Test
    public void alertCreationTest() {

        Alert alert =
                AlertFactory.createAlert(
                        1,
                        "Firewall",
                        "High",
                        "Unauthorized Access");

        assertNotNull(alert);

        assertEquals(
                "Firewall",
                alert.getSource());
    }
}