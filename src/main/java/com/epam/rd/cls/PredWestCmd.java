package com.epam.rd.cls;

import java.util.List;

public class PredWestCmd 
    implements SetCmd<SalesSummaryRow,Boolean> {
    private SalesSummaryRow salesSummaryRow;

    public void set(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public Boolean execute() {
        return salesSummaryRow.getRegion() == Region.WEST;
    }
}
