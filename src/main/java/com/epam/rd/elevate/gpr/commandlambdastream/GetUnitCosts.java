package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class GetUnitCosts
    implements GetDoubleSetSalesSummaryRowCommand {
    private SalesSummaryRow salesSummaryRow;
    private double value;

    public void setSalesSummaryRow(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public double getDouble() {
        return value;
    }

    public void execute() {
        value = salesSummaryRow.getUnitCosts();
    }
}
