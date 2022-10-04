package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class FilterCommand<T> implements Command<List<T>> {
    private List<T> list;
    private SetCommand<T,Boolean> predicate;

    public FilterCommand(List<T> list,
                         SetCommand<T,Boolean> predicate) {
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
