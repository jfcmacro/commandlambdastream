package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ForEachCommand<T,R> {
    private List<T> list;
    private SetCommandTR<T,R> setCommand;

    public ForEachCommand(List<T> list,
                          SetCommandTR<T,R> setCommand) {
        this.list = list;
        this.setCommand = setCommand;
    }

    public R execute() {
        R retValue = null;
        for (T elem: list) {
            setCommand.set(elem);
            retValue = setCommand.execute();
        }
        return retValue;
    }
}
