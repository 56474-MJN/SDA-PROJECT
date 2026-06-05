# ADR-006: Persistence Strategy

## Status
Accepted

## Context

The project requires storage of alerts and incidents.

## Decision

Repository Pattern was selected.

Current implementation uses in-memory repositories:

- AlertRepository
- IncidentRepository

Future versions may use PostgreSQL or MySQL without changing service logic.

## Consequences

Benefits:

- Simplicity
- Fast development
- Loose coupling

Drawbacks:

- Data not retained after application shutdown