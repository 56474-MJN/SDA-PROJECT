// Pattern: Singleton
package com.sdapro.singleton;

public class ConfigManager {

    private static ConfigManager instance;

    private String applicationName;

    private ConfigManager() {

        applicationName = "SDA-PRO";
    }

    public static ConfigManager getInstance() {

        if (instance == null) {

            instance = new ConfigManager();
        }

        return instance;
    }

    public String getApplicationName() {

        return applicationName;
    }
}