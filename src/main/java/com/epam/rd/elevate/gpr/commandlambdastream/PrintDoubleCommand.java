package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class PrintDoubleCommand
    implements SetDoubleCommand {
    private Double value;

    public void execute() {
        System.out.println(value);
    }

    public void setDouble(Double value) {
        this.value = value;
    }
}
