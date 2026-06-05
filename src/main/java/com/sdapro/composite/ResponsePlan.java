// Pattern: Composite
package com.sdapro.composite;

import java.util.ArrayList;
import java.util.List;

public class ResponsePlan
        implements ResponseComponent {

    private List<ResponseComponent> actions =
            new ArrayList<>();

    public void add(ResponseComponent action) {

        actions.add(action);
    }

    @Override
    public void execute() {

        System.out.println(
                "Executing Response Plan");

        for (ResponseComponent action : actions) {

            action.execute();
        }
    }
}