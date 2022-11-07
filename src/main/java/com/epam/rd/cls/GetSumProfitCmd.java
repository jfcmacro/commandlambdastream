package com.epam.rd.cls;

import java.util.List;

public class GetSumProfitCmd
    implements BiSetCommand<SalesSummaryRow,Double,Double> {
    private SalesSummaryRow salesSummaryRow;
    private Double value;

    public void set(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public void set2(Double value) {
        this.value = value;
    }

    public Double execute() {
        return value + salesSummaryRow.profit();
    }
}
