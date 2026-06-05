// Pattern: State
package com.sdapro.state;

public class TriageState implements IncidentState {

    @Override
    public String getStateName() {
        return "TRIAGE";
    }

    @Override
    public void nextState(IncidentContext context) {

        System.out.println(
                "Transitioning TRIAGE -> CONTAINMENT");

        context.setState(new ContainmentState());
    }
}