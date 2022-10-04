package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ReduceCommandTR<S,R>
    implements CommandT<R> {
    private List<S> list;
    private R initValue;
    private BiSetCommandSTR<S,R,R> biSetCommand;

    public ReduceCommandTR(List<S> list,
                           BiSetCommandSTR<S,R,R> biSetCommand,
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
