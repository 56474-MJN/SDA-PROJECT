// Pattern: Test - Singleton
package com.sdapro;

import com.sdapro.singleton.ConfigManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigManagerTest {

    @Test
    public void singletonTest() {

        ConfigManager first =
                ConfigManager.getInstance();

        ConfigManager second =
                ConfigManager.getInstance();

        assertSame(
                first,
                second);
    }
}