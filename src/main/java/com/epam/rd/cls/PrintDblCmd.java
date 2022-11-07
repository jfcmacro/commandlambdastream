package com.epam.rd.cls;

import java.util.List;

public class PrintDblCmd
    implements SetDblCmd {
    private double value;

    public void execute() {
        System.out.println(value);
    }

    public void setDbl(double value) {
        this.value = value;
    }
}
