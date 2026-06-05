# ADR-005: External Integration Strategy

## Status
Accepted

## Context

The system integrates with external cybersecurity services.

Examples:

- VirusTotal
- MISP
- Slack
- PagerDuty

## Decision

Adapter Pattern was used to standardize communication.

Adapters:

- VirusTotalAdapter
- MISPAdapter
- SlackAdapter
- PagerDutyAdapter

## Consequences

Benefits:

- Consistent interfaces
- Easier future integrations
- Reduced dependency on vendor APIs

Drawbacks:

- Additional abstraction layer