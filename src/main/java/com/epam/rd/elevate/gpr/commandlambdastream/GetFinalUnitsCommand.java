package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class GetFinalUnitsCommand
    implements SetCommandTR<SalesSummaryRow,Integer> {
    private SalesSummaryRow salesSummaryRow;

    public void set(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }
    public Integer execute() {
        return salesSummaryRow.finalUnits();
    }
}
