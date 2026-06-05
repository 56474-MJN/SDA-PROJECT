# SDA Pro - Source Code Structure

## Project Overview
SDA Pro (Security Detection and Response Application) is a Java-based incident response system that implements multiple software design patterns for managing security alerts, incidents, and automated response actions.

---

## Package Hierarchy

```
com.sdapro
├── Main.java (Main Entry Point)
├── abstractfactory/          (Abstract Factory Pattern)
│   ├── BlockIPFactory.java
│   ├── BlockIPAction.java
│   ├── IsolateEndpointFactory.java
│   ├── IsolateEndpointAction.java
│   ├── ResponseFactory.java (Interface)
│   └── ResponseAction.java (Interface)
│
├── adapter/                  (Adapter Pattern)
│   ├── ThreatIntelService.java (Interface)
│   ├── VirusTotalAdapter.java
│   └── MISPAdapter.java
│
├── chain/                    (Chain of Responsibility Pattern)
│   ├── AlertHandler.java (Abstract Base)
│   ├── AssetContextHandler.java
│   ├── ClassificationHandler.java
│   ├── DeduplicationHandler.java
│   ├── GeoIPHandler.java
│   └── ThreatIntelHandler.java
│
├── composite/                (Composite Pattern)
│   ├── ResponseComponent.java (Interface)
│   ├── ResponseActionLeaf.java
│   ├── ResponsePlan.java
│   ├── SingleAlert.java
│   └── AlertCampaign.java
│
├── controller/               (MVC Controller)
│   ├── AlertController.java
│   ├── IncidentController.java
│   └── DashboardController.java
│
├── decorator/                (Decorator Pattern)
│   ├── Action.java (Interface)
│   ├── ActionDecorator.java (Abstract)
│   ├── BasicAction.java
│   ├── AuditDecorator.java
│   ├── ApprovalDecorator.java
│   ├── MetricsDecorator.java
│   └── RollbackDecorator.java
│
├── eventbus/                 (Observer/Event Bus Pattern)
│   ├── EventSubscriber.java (Interface)
│   ├── EventBusPublisher.java
│   ├── AuditEventLogger.java
│   ├── DashboardUpdater.java
│   ├── MetricsCollector.java
│   └── NotificationDispatcher.java
│
├── facade/                   (Facade Pattern)
│   └── IncidentResponseFacade.java
│
├── factory/                  (Factory Pattern)
│   └── AlertFactory.java
│
├── integration/              (Integration Pattern)
│   ├── SecurityPlatform.java (Interface)
│   ├── VirusTotalAdapter.java
│   ├── MISPAdapter.java
│   ├── SlackAdapter.java
│   └── PagerDutyAdapter.java
│
├── model/                    (MVC Model)
│   ├── Alert.java
│   └── Incident.java
│
├── models/                   (MVC Model - UI specific)
│   ├── AlertStreamModel.java
│   ├── IncidentQueueModel.java
│   └── DashboardMetricsModel.java
│
├── normalizer/               (Strategy Pattern - Normalizers)
│   ├── AlertNormalizer.java (Interface)
│   ├── AlertNormalizerFactory.java
│   ├── SplunkNormalizer.java
│   ├── CrowdStrikeNormalizer.java
│   ├── FirewallNormalizer.java
│   └── CloudSIEMNormalizer.java
│
├── notification/             (Factory/Strategy Pattern)
│   ├── Notifier.java (Interface)
│   ├── NotificationFactory.java
│   ├── EmailNotificationFactory.java
│   ├── EmailNotifier.java
│   ├── SlackNotificationFactory.java
│   ├── SlackNotifier.java
│   ├── PagerDutyNotificationFactory.java
│   └── PagerDutyNotifier.java
│
├── observer/                 (Observer Pattern)
│   ├── Observer.java (Interface)
│   ├── EventManager.java
│   ├── DashboardObserver.java
│   ├── AuditObserver.java
│   └── NotificationObserver.java
│
├── proxy/                    (Proxy Pattern)
│   └── ThreatIntelProxy.java
│
├── repository/               (Repository Pattern)
│   ├── AlertRepository.java
│   └── IncidentRepository.java
│
├── service/                  (Service Layer)
│   ├── AlertIngestionService.java
│   ├── IncidentService.java
│   ├── ResponseService.java
│   ├── ThreatIntelService.java
│   ├── NotificationService.java
│   └── AuditService.java
│
├── singleton/                (Singleton Pattern)
│   └── ConfigManager.java
│
├── state/                    (State Pattern)
│   ├── IncidentState.java (Interface)
│   ├── IncidentContext.java
│   ├── NewState.java
│   ├── TriageState.java
│   ├── ContainmentState.java
│   ├── EradicationState.java
│   ├── RecoveryState.java
│   ├── PostIncidentReviewState.java
│   └── ClosedState.java
│
├── strategy/                 (Strategy Pattern)
│   ├── ResponseStrategy.java (Interface)
│   ├── AggressiveStrategy.java
│   ├── BalancedStrategy.java
│   ├── ConservativeStrategy.java
│   └── WatchAndWaitStrategy.java
│
└── ui/                       (MVC View)
    ├── DashboardFrame.java
    └── DashboardLauncher.java
```

---

## Design Patterns Usage

| Pattern | Location | Purpose |
|---------|----------|---------|
| **Abstract Factory** | `abstractfactory/` | Creates families of response actions (BlockIP, IsolateEndpoint) |
| **Adapter** | `adapter/` | Adapts third-party threat intel services (VirusTotal, MISP) |
| **Chain of Responsibility** | `chain/` | Chains alert handlers for processing (context, classification, dedup, etc.) |
| **Composite** | `composite/` | Composes single alerts and alert campaigns into tree structures |
| **Decorator** | `decorator/` | Decorates actions with cross-cutting concerns (Audit, Approval, Metrics, Rollback) |
| **Facade** | `facade/` | Provides simplified interface to incident response subsystem |
| **Factory** | `factory/` | Creates alert objects |
| **Observer** | `observer/` | Observers track incident state changes (Dashboard, Audit, Notification) |
| **Event Bus** | `eventbus/` | Publishes and subscribes to system events |
| **Proxy** | `proxy/` | Proxies threat intelligence service calls |
| **Repository** | `repository/` | Data access layer for alerts and incidents |
| **Singleton** | `singleton/` | Manages application configuration (ConfigManager) |
| **State** | `state/` | Manages incident lifecycle states (New → Triage → Containment → Recovery → Closed) |
| **Strategy** | `strategy/` | Selects response strategy (Aggressive, Balanced, Conservative, WatchAndWait) |
| **Strategy (Normalizer)** | `normalizer/` | Normalizes alerts from different sources (Splunk, CrowdStrike, Firewall, Cloud SIEM) |
| **Service Layer** | `service/` | Business logic services for alerts, incidents, notifications, auditing |
| **MVC (Controller)** | `controller/` | Controllers for alerts, incidents, and dashboard |
| **MVC (View)** | `ui/` | UI components for dashboard |
| **MVC (Model)** | `model/`, `models/` | Data models for domain objects and UI models |

---

## Core Data Flow

```
Alert Ingestion
    ↓
[AlertIngestionService] → [AlertFactory]
    ↓
[Chain of Responsibility] 
  - AssetContextHandler
  - DeduplicationHandler
  - ClassificationHandler
  - GeoIPHandler
  - ThreatIntelHandler
    ↓
[Incident Creation] → [IncidentRepository]
    ↓
[Observer Pattern - Notify]
  - DashboardObserver
  - AuditObserver
  - NotificationObserver
    ↓
[Response Strategy Selection]
  - Aggressive
  - Balanced
  - Conservative
  - WatchAndWait
    ↓
[Abstract Factory] → ResponseActions
  - BlockIPFactory
  - IsolateEndpointFactory
    ↓
[Decorator Pattern] - Enhance Actions
  - AuditDecorator
  - ApprovalDecorator
  - MetricsDecorator
  - RollbackDecorator
    ↓
[Composite Pattern] → ResponsePlan
    ↓
[Event Bus] → Notifications
    ↓
Dashboard Update / Notifications
```

---

## Key Classes by Responsibility

### Alert Management
- `Alert.java` - Alert domain model
- `AlertRepository.java` - Alert persistence
- `AlertFactory.java` - Alert creation
- `AlertIngestionService.java` - Alert intake and processing

### Incident Management
- `Incident.java` - Incident domain model
- `IncidentRepository.java` - Incident persistence
- `IncidentService.java` - Incident business logic
- `IncidentState.java` - Incident state interface
- `IncidentContext.java` - State context

### Response Actions
- `ResponseAction.java` - Response action interface
- `ResponseFactory.java` - Response factory interface
- `Action.java` - Decorator target interface
- `BasicAction.java` - Base action implementation
- Decorators: `AuditDecorator`, `ApprovalDecorator`, `MetricsDecorator`, `RollbackDecorator`

### Strategy & Decision Making
- `ResponseStrategy.java` - Strategy interface
- Strategy Implementations: `AggressiveStrategy`, `BalancedStrategy`, `ConservativeStrategy`, `WatchAndWaitStrategy`
- `AlertNormalizer.java` - Normalizer interface
- Normalizer Implementations: `SplunkNormalizer`, `CrowdStrikeNormalizer`, `FirewallNormalizer`, `CloudSIEMNormalizer`

### Event & Notification
- `EventSubscriber.java` - Event subscriber interface
- `EventBusPublisher.java` - Event bus publisher
- `Notifier.java` - Notifier interface
- Notifier Implementations: `EmailNotifier`, `SlackNotifier`, `PagerDutyNotifier`
- Observers: `DashboardObserver`, `AuditObserver`, `NotificationObserver`

### External Integration
- `ThreatIntelService.java` - Threat intel interface
- Adapters: `VirusTotalAdapter`, `MISPAdapter`
- `SecurityPlatform.java` - Security platform interface
- Platform Adapters: `VirusTotalAdapter`, `MISPAdapter`, `SlackAdapter`, `PagerDutyAdapter`

### Configuration & Facade
- `ConfigManager.java` - Singleton configuration
- `IncidentResponseFacade.java` - Main facade for incident response operations

### UI & Presentation
- `DashboardLauncher.java` - Application launcher
- `DashboardFrame.java` - Main UI frame
- `DashboardController.java` - Dashboard controller
- Models: `AlertStreamModel`, `IncidentQueueModel`, `DashboardMetricsModel`

---

## File Statistics

- **Total Source Files**: 79 (main) + 8 (test) = 87 files
- **Total Packages**: 20
- **Design Patterns Implemented**: 16+
- **Lines of Code**: ~12,000+ (estimated)

---

## Test Files

Located in `src/test/java/com/sdapro/`:

- `ConfigManagerTest.java` - Singleton pattern tests
- `AlertFactoryTest.java` - Factory pattern tests
- `IncidentStateTest.java` - State pattern tests
- `ResponseStrategyTest.java` - Strategy pattern tests
- `DecoratorTest.java` - Decorator pattern tests
- `ObserverTest.java` - Observer pattern tests
- `CompositeTest.java` - Composite pattern tests
- `FacadeTest.java` - Facade pattern tests

---

## Build & Compilation

- **Build Tool**: Maven (pom.xml)
- **Compiled Output**: `target/classes/com/sdapro/`
- **Language**: Java 8+

---

## Entry Point

**Main Application**: `com.sdapro.Main.java`

The main entry point orchestrates:
1. Configuration loading via Singleton
2. Alert ingestion setup
3. Handler chain initialization
4. Observer registration
5. Strategy selection
6. Facade initialization
7. UI launcher

---

## Documentation

ADRs (Architectural Decision Records) located in `docs/adr/`:
- ADR-001: Use Design Patterns for Flexibility
- ADR-002: Event-Driven Architecture
- ADR-003: Composite Pattern for Response Plans
- ADR-004: Decorator for Cross-Cutting Concerns
- ADR-005: Integration Adapters

---

**Last Updated**: June 3, 2026
**Architecture Style**: Pattern-Rich, Event-Driven, Layered with Facade
