// Pattern: State
package com.sdapro.state;

public class ClosedState implements IncidentState {

    @Override
    public String getStateName() {
        return "CLOSED";
    }

    @Override
    public void nextState(IncidentContext context) {

        System.out.println(
                "Incident already closed");
    }
}