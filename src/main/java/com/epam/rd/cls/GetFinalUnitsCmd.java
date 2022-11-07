package com.epam.rd.cls;

import java.util.List;

public class GetFinalUnitsCmd
    implements GetIntSetSlsSumRwCmd {
    private SalesSummaryRow salesSummaryRow;
    private int value;

    public void setSlsSumRw(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public int getInt() {
        return value;
    }

    public void execute() {
        value = salesSummaryRow.finalUnits();
    }
}
