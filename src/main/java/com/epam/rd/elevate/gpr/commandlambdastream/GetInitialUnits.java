package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class GetInitialUnits
    implements GetIntegerSetSalesSummaryRowCommand {
    private SalesSummaryRow salesSummaryRow;
    private int value;

    public void setSalesSummaryRow(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public int getInteger() {
        return value;
    }

    public void execute() {
        value = salesSummaryRow.getInitialUnits();
    }

}
