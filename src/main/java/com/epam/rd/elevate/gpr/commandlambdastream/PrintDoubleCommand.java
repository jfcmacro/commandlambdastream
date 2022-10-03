package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class PrintDoubleCommand
    implements SetDoubleCommand {
    private double value;

    public void execute() {
        System.out.println(value);
    }

    public void setDouble(double value) {
        this.value = value;
    }
}
