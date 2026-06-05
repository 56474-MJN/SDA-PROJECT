// Pattern: Facade
package com.sdapro.facade;

import com.sdapro.chain.ClassificationHandler;
import com.sdapro.chain.DeduplicationHandler;
import com.sdapro.chain.GeoIPHandler;
import com.sdapro.chain.ThreatIntelHandler;
import com.sdapro.model.Alert;
import com.sdapro.observer.AuditObserver;
import com.sdapro.observer.DashboardObserver;
import com.sdapro.observer.EventManager;
import com.sdapro.observer.NotificationObserver;
import com.sdapro.proxy.ThreatIntelProxy;

public class IncidentResponseFacade {

    public void handleIncident(Alert alert) {

        System.out.println();
        System.out.println("===== FACADE START =====");

        EventManager eventManager =
                new EventManager();

        eventManager.subscribe(
                new DashboardObserver());

        eventManager.subscribe(
                new AuditObserver());

        eventManager.subscribe(
                new NotificationObserver());

        eventManager.notifyObservers(
                "Incident Created Through Facade");

        ThreatIntelProxy proxy =
                new ThreatIntelProxy();

        proxy.fetchThreatData(
                "192.168.1.10");

        DeduplicationHandler dedup =
                new DeduplicationHandler();

        GeoIPHandler geo =
                new GeoIPHandler();

        ThreatIntelHandler threat =
                new ThreatIntelHandler();

        ClassificationHandler classify =
                new ClassificationHandler();

        dedup.setNextHandler(geo);
        geo.setNextHandler(threat);
        threat.setNextHandler(classify);

        dedup.handle(alert);

        System.out.println();
        System.out.println("===== FACADE END =====");
    }
}