package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class FilterCmd<T> implements Command<List<T>> {
    private List<T> list;
    private SetCmd<T,Boolean> predicate;

    public FilterCmd(List<T> list,
                     SetCmd<T,Boolean> predicate) {
        this.list = list;
        this.predicate = predicate;
    }

    public List<T> execute() {
        List<T> listOut = new ArrayList<T>();
        for (T item: list) {
            predicate.set(item);
            if (predicate.execute()) {
                listOut.add(item);
            }
        }
        return listOut;
    }
}
