// Pattern: State
package com.sdapro.state;

public class ContainmentState implements IncidentState {

    @Override
    public String getStateName() {
        return "CONTAINMENT";
    }

    @Override
    public void nextState(IncidentContext context) {

        System.out.println(
                "Transitioning CONTAINMENT -> RECOVERY");

        context.setState(
        new EradicationState());
    }
}