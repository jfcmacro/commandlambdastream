package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ReduceCommand<S,R>
    implements Command<R> {
    private List<S> list;
    private R initValue;
    private BiSetCommand<S,R,R> biSetCommand;

    public ReduceCommand(List<S> list,
                         BiSetCommand<S,R,R> biSetCommand,
                         R initValue) {
        this.list = list;
        this.biSetCommand = biSetCommand;
        this.initValue = initValue;
    }

    public R execute() {
        R retValue = initValue;
        for (S item: list) {
            biSetCommand.set(item);
            biSetCommand.set2(retValue);
            retValue = biSetCommand.execute();
        }
        return retValue;
    }
}
