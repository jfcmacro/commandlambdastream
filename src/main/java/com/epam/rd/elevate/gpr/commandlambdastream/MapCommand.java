package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class MapCommand<T,R>
    implements Command<List<R>> {
    private List<T> list;
    private SetCommand<T,R> setCommand;

    public MapCommand(List<T> list,
                      SetCommand<T,R> setCommand) {
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
