// Pattern: Decorator
package com.sdapro.decorator;

public class BasicAction implements Action {

    @Override
    public void execute() {

        System.out.println(
                "Executing Response Action");
    }
}