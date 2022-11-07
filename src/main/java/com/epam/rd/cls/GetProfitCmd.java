package com.epam.rd.cls;

import java.util.List;

public class GetProfitCmd
    implements SetCmd<SalesSummaryRow,Double> {
    private SalesSummaryRow salesSummaryRow;

    public void set(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public Double execute() {
        return salesSummaryRow.profit();
    }
}
