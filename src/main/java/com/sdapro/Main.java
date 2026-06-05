// Pattern: Main Entry Point
package com.sdapro;

import com.sdapro.abstractfactory.BlockIPFactory;
import com.sdapro.abstractfactory.IsolateEndpointFactory;
import com.sdapro.abstractfactory.ResponseAction;
import com.sdapro.abstractfactory.ResponseFactory;

import com.sdapro.chain.AssetContextHandler;
import com.sdapro.chain.ClassificationHandler;
import com.sdapro.chain.DeduplicationHandler;
import com.sdapro.chain.GeoIPHandler;
import com.sdapro.chain.ThreatIntelHandler;

import com.sdapro.composite.ResponseActionLeaf;
import com.sdapro.composite.ResponseComponent;
import com.sdapro.composite.ResponsePlan;

import com.sdapro.decorator.Action;
import com.sdapro.decorator.ApprovalDecorator;
import com.sdapro.decorator.AuditDecorator;
import com.sdapro.decorator.BasicAction;
import com.sdapro.decorator.MetricsDecorator;
import com.sdapro.decorator.RollbackDecorator;

import com.sdapro.eventbus.AuditEventLogger;
import com.sdapro.eventbus.DashboardUpdater;
import com.sdapro.eventbus.EventBusPublisher;
import com.sdapro.eventbus.MetricsCollector;
import com.sdapro.eventbus.NotificationDispatcher;

import com.sdapro.facade.IncidentResponseFacade;

import com.sdapro.factory.AlertFactory;

import com.sdapro.model.Alert;
import com.sdapro.model.Incident;

import com.sdapro.normalizer.AlertNormalizer;
import com.sdapro.normalizer.AlertNormalizerFactory;

import com.sdapro.notification.EmailNotificationFactory;
import com.sdapro.notification.NotificationFactory;
import com.sdapro.notification.Notifier;
import com.sdapro.notification.PagerDutyNotificationFactory;
import com.sdapro.notification.SlackNotificationFactory;

import com.sdapro.proxy.ThreatIntelProxy;

import com.sdapro.service.IncidentService;
import com.sdapro.service.ResponseService;

import com.sdapro.singleton.ConfigManager;

import com.sdapro.state.IncidentContext;

import com.sdapro.strategy.ResponseStrategy;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("SDA-PRO COMPLETE DEMONSTRATION");
        System.out.println("=================================");

        // FACTORY

        System.out.println();
        System.out.println("===== FACTORY PATTERN =====");

        Alert alert = AlertFactory.createAlert(
                1,
                "Firewall",
                "High",
                "Unauthorized access detected"
        );

        System.out.println("Alert Created");
        System.out.println("Source: " + alert.getSource());

        // INCIDENT SERVICE

        System.out.println();
        System.out.println("===== INCIDENT SERVICE =====");

        IncidentService incidentService =
                new IncidentService();

        Incident incident =
                incidentService.createIncident(alert);

        System.out.println(
                "Incident ID: "
                        + incident.getIncidentId());

        System.out.println(
                "Incident State: "
                        + incident.getState());

        // STATE

        System.out.println();
        System.out.println("===== STATE PATTERN =====");

        IncidentContext context =
                new IncidentContext();

        System.out.println(
                "Current State: "
                        + context.getState().getStateName());

        context.nextState();

        System.out.println(
                "Current State: "
                        + context.getState().getStateName());

        context.nextState();

        System.out.println(
                "Current State: "
                        + context.getState().getStateName());

        // STRATEGY

        System.out.println();
        System.out.println("===== STRATEGY PATTERN =====");

        ResponseService responseService =
                new ResponseService();

        ResponseStrategy strategy =
                responseService.chooseStrategy(
                        alert.getSeverity());

        strategy.executeResponse();

        // EVENT BUS (OBSERVER + SINGLETON)

        System.out.println();
        System.out.println("===== EVENT BUS =====");

        EventBusPublisher bus =
                EventBusPublisher.getInstance();

        bus.subscribe(
                new DashboardUpdater());

        bus.subscribe(
                new AuditEventLogger());

        bus.subscribe(
                new NotificationDispatcher());

        bus.subscribe(
                new MetricsCollector());

        bus.publish(
                "Incident Created Successfully");

        // CHAIN

        System.out.println();
        System.out.println(
                "===== CHAIN OF RESPONSIBILITY =====");

        DeduplicationHandler dedup =
                new DeduplicationHandler();

        GeoIPHandler geo =
                new GeoIPHandler();

        ThreatIntelHandler threat =
                new ThreatIntelHandler();

        AssetContextHandler asset =
                new AssetContextHandler();

        ClassificationHandler classify =
                new ClassificationHandler();

        dedup.setNextHandler(geo);
        geo.setNextHandler(threat);
        threat.setNextHandler(asset);
        asset.setNextHandler(classify);

        dedup.handle(alert);

        // NORMALIZER FACTORY

        System.out.println();
        System.out.println(
                "===== ALERT NORMALIZER FACTORY =====");

        AlertNormalizer firewall =
                AlertNormalizerFactory
                        .createNormalizer(
                                "firewall");

        firewall.normalize();

        AlertNormalizer splunk =
                AlertNormalizerFactory
                        .createNormalizer(
                                "splunk");

        splunk.normalize();

        AlertNormalizer crowdstrike =
                AlertNormalizerFactory
                        .createNormalizer(
                                "crowdstrike");

        crowdstrike.normalize();

        AlertNormalizer cloud =
                AlertNormalizerFactory
                        .createNormalizer(
                                "cloudsiem");

        cloud.normalize();

        // PROXY + ADAPTER

        System.out.println();
        System.out.println(
                "===== PROXY + ADAPTER =====");

        ThreatIntelProxy proxy =
                new ThreatIntelProxy();

        proxy.fetchThreatData(
                "192.168.1.10");

        // FACADE

        System.out.println();
        System.out.println(
                "===== FACADE PATTERN =====");

        IncidentResponseFacade facade =
                new IncidentResponseFacade();

        facade.handleIncident(alert);

        // DECORATOR

        System.out.println();
        System.out.println(
                "===== DECORATOR PATTERN =====");

        Action action =
                new RollbackDecorator(
                        new MetricsDecorator(
                                new ApprovalDecorator(
                                        new AuditDecorator(
                                                new BasicAction()
                                        )
                                )
                        )
                );

        action.execute();

        // SINGLETON

        System.out.println();
        System.out.println(
                "===== SINGLETON PATTERN =====");

        ConfigManager config1 =
                ConfigManager.getInstance();

        ConfigManager config2 =
                ConfigManager.getInstance();

        System.out.println(
                "Application: "
                        + config1.getApplicationName());

        System.out.println(
                "Same Instance: "
                        + (config1 == config2));

        // ABSTRACT FACTORY

        System.out.println();
        System.out.println(
                "===== ABSTRACT FACTORY =====");

        ResponseFactory blockFactory =
                new BlockIPFactory();

        ResponseAction blockAction =
                blockFactory.createAction();

        blockAction.execute();

        ResponseFactory isolateFactory =
                new IsolateEndpointFactory();

        ResponseAction isolateAction =
                isolateFactory.createAction();

        isolateAction.execute();

        // PDF NOTIFICATION FACTORY

        System.out.println();
        System.out.println(
                "===== NOTIFICATION FACTORY =====");

        NotificationFactory emailFactory =
                new EmailNotificationFactory();

        Notifier email =
                emailFactory.createNotifier();

        email.send(
                "Critical Incident Created");

        NotificationFactory slackFactory =
                new SlackNotificationFactory();

        Notifier slack =
                slackFactory.createNotifier();

        slack.send(
                "Critical Incident Created");

        NotificationFactory pagerFactory =
                new PagerDutyNotificationFactory();

        Notifier pager =
                pagerFactory.createNotifier();

        pager.send(
                "Critical Incident Created");

        // COMPOSITE

        System.out.println();
        System.out.println(
                "===== COMPOSITE PATTERN =====");

        ResponsePlan plan =
                new ResponsePlan();

        ResponseComponent blockIp =
                new ResponseActionLeaf(
                        "Block IP");

        ResponseComponent isolateEndpoint =
                new ResponseActionLeaf(
                        "Isolate Endpoint");

        ResponseComponent disableAccount =
                new ResponseActionLeaf(
                        "Disable Account");

        plan.add(blockIp);
        plan.add(isolateEndpoint);
        plan.add(disableAccount);

        plan.execute();

        System.out.println();
        System.out.println(
                "===== DEMO COMPLETED =====");
    }
}