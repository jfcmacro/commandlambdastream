package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class ReduceIntCmd
    implements GetIntCmd {
    private List<SalesSummaryRow> listSlsSumRw;
    private int retInt;
    private GetIntSetIntSetSlsSumRwCmd integerIntSlsSumRwCmd;

    public ReduceIntCmd(List<SalesSummaryRow> listSlsSumRw,
                            GetIntSetIntSetSlsSumRwCmd integerIntSlsSumRwCmd,
                            int initialInt) {
        this.listSlsSumRw = listSlsSumRw;
        this.integerIntSlsSumRwCmd = integerIntSlsSumRwCmd;
        this.retInt = initialInt;
    }

    public int getInt() {
        return retInt;
    }

    public void execute() {
        for (SalesSummaryRow salesSummaryRow: listSlsSumRw) {
            integerIntSlsSumRwCmd.setInt(retInt);
            integerIntSlsSumRwCmd.setSlsSumRw(salesSummaryRow);
            integerIntSlsSumRwCmd.execute();
            retInt = integerIntSlsSumRwCmd.getInt();
        }
    }
}
