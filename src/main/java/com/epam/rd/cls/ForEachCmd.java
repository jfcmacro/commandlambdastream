package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class ForEachCmd<T,R> {
    private List<T> list;
    private SetCmd<T,R> setCmd;

    public ForEachCmd(List<T> list,
                      SetCmd<T,R> setCmd) {
        this.list = list;
        this.setCmd = setCmd;
    }

    public R execute() {
        R retValue = null;
        for (T elem: list) {
            setCmd.set(elem);
            retValue = setCmd.execute();
        }
        return retValue;
    }
}
