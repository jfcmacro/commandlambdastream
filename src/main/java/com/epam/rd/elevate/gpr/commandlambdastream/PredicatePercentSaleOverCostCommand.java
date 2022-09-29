package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class PredicatePercentSaleOverCostCommand
    implements GetBooleanSetSalesSummaryRowCommand {
    private SalesSummaryRow salesSummaryRow;
    private boolean predicate = false;
    private double  percent;

    public PredicatePercentSaleOverCostCommand(double percent) {
        this.percent = percent;
    }

    public void setSalesSummaryRow(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public boolean getBoolean() {
        return predicate;
    }

    public void execute() {
        predicate = (salesSummaryRow.getUnitSalesValue() /
                     salesSummaryRow.getUnitCosts()) > percent;
    }
}
