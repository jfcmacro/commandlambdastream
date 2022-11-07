package com.epam.rd.cls;

import java.util.List;

public class GetFinalUnitsCmd
    implements SetCmd<SalesSummaryRow,Integer> {
    private SalesSummaryRow salesSummaryRow;

    public void set(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }
    public Integer execute() {
        return salesSummaryRow.finalUnits();
    }
}
