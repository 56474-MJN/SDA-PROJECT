// Pattern: Abstract Factory
package com.sdapro.abstractfactory;

public class BlockIPAction implements ResponseAction {

    @Override
    public void execute() {

        System.out.println(
                "Blocking Malicious IP");
    }
}