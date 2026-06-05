// Pattern: MVC Controller
package com.sdapro.controller;

import com.sdapro.models.AlertStreamModel;
import com.sdapro.repository.AlertRepository;

public class AlertController {

    private AlertStreamModel model;

    private AlertRepository repository;

    public AlertController(
            AlertStreamModel model,
            AlertRepository repository) {

        this.model = model;
        this.repository = repository;
    }

    public String createAlert() {

        String alert =
                "Firewall Alert Created";

        model.addAlert(alert);

        repository.saveAlert(alert);

        return alert;
    }

    public int getAlertCount() {

        return model.getAlertCount();
    }

    public int getStoredAlertCount() {

        return repository.countAlerts();
    }
}