// Pattern: State
package com.sdapro.state;

public class EradicationState
        implements IncidentState {

    @Override
    public String getStateName() {

        return "ERADICATION";
    }

    @Override
    public void nextState(
            IncidentContext context) {

        System.out.println(
                "Transitioning ERADICATION -> RECOVERY");

        context.setState(
                new RecoveryState());
    }
}