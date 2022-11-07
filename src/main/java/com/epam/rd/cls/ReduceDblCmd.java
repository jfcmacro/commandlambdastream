package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class ReduceDblCmd
    implements GetDblCmd {
    private List<SalesSummaryRow> listSlsSumRw;
    private double retDbl;
    private GetDblSetDblSetSlsSumRwCmd doubleDblSlsSumRwCmd;

    public ReduceDblCmd(List<SalesSummaryRow> listSlsSumRw,
                           GetDblSetDblSetSlsSumRwCmd doubleDblSlsSumRwCmd,
                           double initialDbl) {
        this.listSlsSumRw = listSlsSumRw;
        this.doubleDblSlsSumRwCmd = doubleDblSlsSumRwCmd;
        this.retDbl = initialDbl;
    }

    public double getDbl() {
        return retDbl;
    }

    public void execute() {
        for (SalesSummaryRow salesSummaryRow: listSlsSumRw) {
            doubleDblSlsSumRwCmd.setDbl(retDbl);
            doubleDblSlsSumRwCmd.setSlsSumRw(salesSummaryRow);
            doubleDblSlsSumRwCmd.execute();
            retDbl = doubleDblSlsSumRwCmd.getDbl();
        }
    }
}
