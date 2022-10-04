package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class MapCommandTR<T,R>
    implements CommandT<List<R>> {
    private List<T> list;
    private SetCommandTR<T,R> setCommand;

    public MapCommandTR(List<T> list,
                        SetCommandTR<T,R> setCommand) {
        this.list = list;
        this.setCommand = setCommand;
    }

    public List<R> execute() {
        List<R> retList;retList = new ArrayList<R>();
        for (T item: list) {
            setCommand.set(item);
            retList.add(setCommand.execute());
        }
        return retList;
    }
}
