package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class PredicatePercentSaleOverCostCommand
    implements SetCommand<SalesSummaryRow,Boolean> {
    private SalesSummaryRow salesSummaryRow;
    private double  percent;

    public PredicatePercentSaleOverCostCommand(double percent) {
        this.percent = percent;
    }

    public void set(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public Boolean execute() {
        return (salesSummaryRow.getUnitSalesValue() /
                salesSummaryRow.getUnitCosts()) > percent;
    }
}
