// Pattern: State
package com.sdapro.state;

public interface IncidentState {

    String getStateName();

    void nextState(IncidentContext context);
}