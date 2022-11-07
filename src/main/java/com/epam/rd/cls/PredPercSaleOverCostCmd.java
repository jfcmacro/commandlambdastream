package com.epam.rd.cls;

import java.util.List;

public class PredPercSaleOverCostCmd
    implements SetCmd<SalesSummaryRow,Boolean> {
    private SalesSummaryRow salesSummaryRow;
    private double  percent;

    public PredPercSaleOverCostCmd(double percent) {
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
