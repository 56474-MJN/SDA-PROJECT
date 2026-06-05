// Pattern: Test - Observer
package com.sdapro;

import com.sdapro.eventbus.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    @Test
    void singletonEventBusExists() {

        EventBusPublisher bus =
                EventBusPublisher.getInstance();

        assertNotNull(bus);
    }
}