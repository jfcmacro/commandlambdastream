package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class PrintIntegerCommand
    implements SetIntegerCommand {
    private Integer integer;

    public void execute() {
        System.out.println(integer);
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
