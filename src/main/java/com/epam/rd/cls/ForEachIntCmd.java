package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class ForEachIntCmd {
    private List<Integer> listInt;
    private SetIntCmd setIntCmd;

    public ForEachIntCmd(List<Integer> listInt,
                         SetIntCmd setIntCmd) {
        this.listInt = listInt;
        this.setIntCmd = setIntCmd;
    }

    public void execute() {
        for (Integer integer: listInt) {
            setIntCmd.setInt(integer);
            setIntCmd.execute();
        }
    }
}
