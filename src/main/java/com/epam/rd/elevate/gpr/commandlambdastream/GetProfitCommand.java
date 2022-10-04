package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class GetProfitCommand
    implements SetCommandTR<SalesSummaryRow,Double> {
    private SalesSummaryRow salesSummaryRow;

    public void set(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public Double execute() {
        return salesSummaryRow.profit();
    }
}
