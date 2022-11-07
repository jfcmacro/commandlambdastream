package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class ReduceCmd<S,R>
    implements Command<R> {
    private List<S> list;
    private R initValue;
    private BiSetCommand<S,R,R> biSetCmd;

    public ReduceCmd(List<S> list,
                     BiSetCommand<S,R,R> biSetCmd,
                     R initValue) {
        this.list = list;
        this.biSetCmd = biSetCmd;
        this.initValue = initValue;
    }

    public R execute() {
        R retValue = initValue;
        for (S item: list) {
            biSetCmd.set(item);
            biSetCmd.set2(retValue);
            retValue = biSetCmd.execute();
        }
        return retValue;
    }
}
