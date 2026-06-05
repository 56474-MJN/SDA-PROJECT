# ADR-003: Event Bus Implementation

## Status
Accepted

## Context

Multiple components need notification when incidents or alerts are created.

Examples:

- Dashboard updates
- Audit logging
- Notifications
- Metrics collection

## Decision

An EventBusPublisher singleton was implemented using the Observer Pattern.

Observers:

- DashboardUpdater
- AuditEventLogger
- NotificationDispatcher
- MetricsCollector

## Consequences

Benefits:

- Loose coupling
- Easy addition of new observers
- Better scalability

Drawbacks:

- More event management complexity