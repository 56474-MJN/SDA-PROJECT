// Pattern: State
package com.sdapro.state;

public class PostIncidentReviewState
        implements IncidentState {

    @Override
    public String getStateName() {

        return "POST INCIDENT REVIEW";
    }

    @Override
    public void nextState(
            IncidentContext context) {

        System.out.println(
                "Transitioning POST INCIDENT REVIEW -> CLOSED");

        context.setState(
                new ClosedState());
    }
}