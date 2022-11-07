package com.epam.rd.cls;

import java.util.List;

public class PrintCmd<T,Void>
    implements SetCmd<T,Void> {
    private T elem;

    public Void execute() {
        System.out.println(elem.toString());
        return null;
    }

    public void set(T elem) {
        this.elem = elem;
    }
}
