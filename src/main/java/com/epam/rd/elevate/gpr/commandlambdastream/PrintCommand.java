package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class PrintCommand<T,Void>
    implements SetCommandTR<T,Void> {
    private T elem;

    public Void execute() {
        System.out.println(elem.toString());
        return null;
    }

    public void set(T elem) {
        this.elem = elem;
    }
}
