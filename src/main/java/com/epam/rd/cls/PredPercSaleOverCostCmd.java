package com.epam.rd.cls;

import java.util.List;

public class PredPercSaleOverCostCmd
    implements GetBoolSetSlsSumRwCmd {
    private SalesSummaryRow salesSummaryRow;
    private boolean pred = false;
    private double  perc;

    public PredPercSaleOverCostCmd(double perc) {
        this.perc = perc;
    }

    public void setSlsSumRw(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public boolean getBool() {
        return pred;
    }

    public void execute() {
        pred = (salesSummaryRow.getUnitSalesValue() /
                salesSummaryRow.getUnitCosts()) > perc;
    }
}
