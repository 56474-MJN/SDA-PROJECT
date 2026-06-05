// Pattern: State
package com.sdapro.state;

public class IncidentContext {

    private IncidentState state;

    public IncidentContext() {
        state = new NewState();
    }

    public void setState(IncidentState state) {
        this.state = state;
    }

    public IncidentState getState() {
        return state;
    }

    public void nextState() {
        state.nextState(this);
    }
}