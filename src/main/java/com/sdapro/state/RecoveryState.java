// Pattern: State
package com.sdapro.state;

public class RecoveryState implements IncidentState {

    @Override
    public String getStateName() {
        return "RECOVERY";
    }

    @Override
    public void nextState(IncidentContext context) {

        System.out.println(
                "Transitioning RECOVERY -> CLOSED");

        context.setState(
        new PostIncidentReviewState());
    }
}