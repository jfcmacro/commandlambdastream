package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class PredicateWestCommand implements GetBooleanSetSalesSummaryRowCommand {
    private SalesSummaryRow salesSummaryRow;
    private boolean predicate = false;

    public void setSalesSummaryRow(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public boolean getBoolean() {
        return predicate;
    }

    public void execute() {
        predicate =  salesSummaryRow.getRegion() == Region.WEST;
    }
}
