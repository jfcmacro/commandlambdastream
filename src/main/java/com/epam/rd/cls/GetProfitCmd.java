package com.epam.rd.cls;

import java.util.List;

public class GetProfitCmd
    implements GetDblSetSlsSumRwCmd {
    private SalesSummaryRow salesSummaryRow;
    private double value;

    public void setSlsSumRw(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public double getDbl() {
        return value;
    }

    public void execute() {
        value = salesSummaryRow.profit();
    }
}
