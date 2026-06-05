// Pattern: State
package com.sdapro.state;

public class NewState implements IncidentState {

    @Override
    public String getStateName() {
        return "NEW";
    }

    @Override
    public void nextState(IncidentContext context) {

        System.out.println(
                "Transitioning NEW -> TRIAGE");

        context.setState(new TriageState());
    }
}