package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class PrintSalesSummaryRowCommand
    implements SetSalesSummaryRowCommand {
    private SalesSummaryRow salesSummaryRow;

    public void execute() {
        System.out.println(salesSummaryRow.toString());
    }

    public void setSalesSummaryRow(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }
}
