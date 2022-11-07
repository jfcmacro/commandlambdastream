package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class ForEachDblCmd {
    private List<Double> listDbl;
    private SetDblCmd setDblCmd;

    public ForEachDblCmd(List<Double> listDbl,
                         SetDblCmd setDblCmd) {
        this.listDbl = listDbl;
        this.setDblCmd = setDblCmd;
    }

    public void execute() {
        for (Double integer: listDbl) {
            setDblCmd.setDbl(integer);
            setDblCmd.execute();
        }
    }
}
