package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class ForEachCmd {
    private List<SalesSummaryRow> listSlsSumRw;
    private SetSlsSumRwCmd salesSummaryRowCmd;

    public ForEachCmd(List<SalesSummaryRow> listSlsSumRw,
                      SetSlsSumRwCmd salesSummaryRowCmd) {
        this.listSlsSumRw = listSlsSumRw;
        this.salesSummaryRowCmd = salesSummaryRowCmd;
    }

    public void execute() {
        for (SalesSummaryRow saleSummaryRow: listSlsSumRw) {
            salesSummaryRowCmd.setSlsSumRw(saleSummaryRow);
            salesSummaryRowCmd.execute();
        }
    }
}
