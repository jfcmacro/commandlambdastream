package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class PredicateEastCommand
    implements SetCommandTR<SalesSummaryRow,Boolean> {
    private SalesSummaryRow salesSummaryRow;

    public void set(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public Boolean execute() {
        return salesSummaryRow.getRegion() == Region.EAST;
    }
}
