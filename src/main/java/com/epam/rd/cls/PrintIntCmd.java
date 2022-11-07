package com.epam.rd.cls;

import java.util.List;

public class PrintIntCmd
    implements SetIntCmd {
    private Integer integer;

    public void execute() {
        System.out.println(integer);
    }

    public void setInt(Integer integer) {
        this.integer = integer;
    }
}
