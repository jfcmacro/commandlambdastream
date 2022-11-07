package com.epam.rd.cls;

import java.util.List;

public class PredNorthCmd implements GetBoolSetSlsSumRwCmd {
    private SalesSummaryRow salesSummaryRow;
    private boolean predicate = false;

    public void setSlsSumRw(SalesSummaryRow salesSummaryRow) {
        this.salesSummaryRow = salesSummaryRow;
    }

    public boolean getBool() {
        return predicate;
    }

    public void execute() {
        predicate =  salesSummaryRow.getRegion() == Region.NORTH;
    }
}
