package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class MapCmd<T,R>
    implements Command<List<R>> {
    private List<T> list;
    private SetCmd<T,R> setCmd;

    public MapCmd(List<T> list,
                  SetCmd<T,R> setCmd) {
        this.list = list;
        this.setCmd = setCmd;
    }

    public List<R> execute() {
        List<R> retList;retList = new ArrayList<R>();
        for (T item: list) {
            setCmd.set(item);
            retList.add(setCmd.execute());
        }
        return retList;
    }
}
