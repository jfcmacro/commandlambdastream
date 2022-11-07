package com.epam.rd.cls;

import java.util.List;

public class GetSumProfitCmd
    implements GetDblSetDblSetSlsSumRwCmd {
    private SalesSummaryRow salesSummaryRow;
    private double value;

    public void setDbl(double value) {
        this.value = value;
    }

    public void setSlsSumRw(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public double getDbl() {
        return value;
    }

    public void execute() {
        value += salesSummaryRow.profit();
    }
}
