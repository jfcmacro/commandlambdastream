package com.epam.rd.cls;

import java.util.List;

public class PrintSlsSumRwCmd
    implements SetSlsSumRwCmd {
    private SalesSummaryRow salesSummaryRow;

    public void execute() {
        System.out.println(salesSummaryRow.toString());
    }

    public void setSlsSumRw(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }
}
