// Pattern: MVC View
package com.sdapro.ui;

import com.sdapro.controller.AlertController;
import com.sdapro.controller.DashboardController;
import com.sdapro.controller.IncidentController;

import com.sdapro.integration.MISPAdapter;
import com.sdapro.integration.PagerDutyAdapter;
import com.sdapro.integration.SecurityPlatform;
import com.sdapro.integration.SlackAdapter;
import com.sdapro.integration.VirusTotalAdapter;

import com.sdapro.models.AlertStreamModel;
import com.sdapro.models.DashboardMetricsModel;
import com.sdapro.models.IncidentQueueModel;

import com.sdapro.repository.AlertRepository;
import com.sdapro.repository.IncidentRepository;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private JTextArea outputArea;

    private AlertController alertController;
    private IncidentController incidentController;
    private DashboardController dashboardController;

    private AlertRepository alertRepository;
    private IncidentRepository incidentRepository;

    public DashboardFrame() {

        AlertStreamModel alertModel =
                new AlertStreamModel();

        IncidentQueueModel incidentModel =
                new IncidentQueueModel();

        DashboardMetricsModel metricsModel =
                new DashboardMetricsModel();

        alertRepository =
                new AlertRepository();

        incidentRepository =
                new IncidentRepository();

        alertController =
                new AlertController(
                        alertModel,
                        alertRepository);

        incidentController =
                new IncidentController(
                        incidentModel,
                        incidentRepository);

        dashboardController =
                new DashboardController(
                        metricsModel);

        setTitle("SDA-PRO SOC Dashboard");

        setSize(1000, 650);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel buttonPanel =
                new JPanel();

        JButton alertButton =
                new JButton("Create Alert");

        JButton incidentButton =
                new JButton("Create Incident");

        JButton responseButton =
                new JButton("Execute Response");

        JButton metricsButton =
                new JButton("Show Metrics");

        JButton repositoryButton =
                new JButton("Repository Stats");

        JButton integrationButton =
                new JButton("Run Integrations");

        buttonPanel.add(alertButton);
        buttonPanel.add(incidentButton);
        buttonPanel.add(responseButton);
        buttonPanel.add(metricsButton);
        buttonPanel.add(repositoryButton);
        buttonPanel.add(integrationButton);

        add(buttonPanel, BorderLayout.NORTH);

        outputArea =
                new JTextArea();

        outputArea.setEditable(false);

        JScrollPane scrollPane =
                new JScrollPane(outputArea);

        add(scrollPane, BorderLayout.CENTER);

        alertButton.addActionListener(e -> {

    com.sdapro.service.AlertIngestionService
            ingestionService =
            new com.sdapro.service.AlertIngestionService();

    com.sdapro.service.ThreatIntelService
            threatIntelService =
            new com.sdapro.service.ThreatIntelService();

    com.sdapro.service.NotificationService
            notificationService =
            new com.sdapro.service.NotificationService();

    com.sdapro.service.AuditService
            auditService =
            new com.sdapro.service.AuditService();

    String alert =
            alertController.createAlert();

    dashboardController.recordAlert();

    outputArea.append(
            alert + "\n");

    outputArea.append(
            ingestionService.ingestAlert(
                    "Firewall")
                    + "\n");

    outputArea.append(
            threatIntelService.enrichAlert(
                    alert)
                    + "\n");

    outputArea.append(
            notificationService.sendNotification(
                    alert)
                    + "\n");

    outputArea.append(
            auditService.logEvent(
                    alert)
                    + "\n\n");
});

        incidentButton.addActionListener(e -> {

            String incident =
                    incidentController.createIncident();

            dashboardController.recordIncident();

            outputArea.append(
                    incident + "\n");
        });

        responseButton.addActionListener(e -> {

            outputArea.append(
                    "Response Plan Executed\n");
        });

        metricsButton.addActionListener(e -> {

            outputArea.append(
                    "\n===== DASHBOARD METRICS =====\n");

            outputArea.append(
                    dashboardController.getMetrics()
                            + "\n\n");
        });

        repositoryButton.addActionListener(e -> {

            outputArea.append(
                    "\n===== REPOSITORY STATS =====\n");

            outputArea.append(
                    "Stored Alerts: "
                            + alertRepository.countAlerts()
                            + "\n");

            outputArea.append(
                    "Stored Incidents: "
                            + incidentRepository.countIncidents()
                            + "\n\n");
        });

      integrationButton.addActionListener(e -> {

    outputArea.append(
            "\n===== EXTERNAL INTEGRATIONS =====\n");

    String latestAlert =
            alertRepository.getLatestAlert();

    SecurityPlatform virusTotal =
            new VirusTotalAdapter();

    SecurityPlatform misp =
            new MISPAdapter();

    SecurityPlatform slack =
            new SlackAdapter();

    SecurityPlatform pagerDuty =
            new PagerDutyAdapter();

    outputArea.append(
            "Latest Alert: "
                    + latestAlert
                    + "\n\n");

    outputArea.append(
            virusTotal.execute(
                    latestAlert)
                    + "\n");

    outputArea.append(
            misp.execute(
                    latestAlert)
                    + "\n");

    outputArea.append(
            slack.execute(
                    latestAlert)
                    + "\n");

    outputArea.append(
            pagerDuty.execute(
                    latestAlert)
                    + "\n\n");
});
    }
}