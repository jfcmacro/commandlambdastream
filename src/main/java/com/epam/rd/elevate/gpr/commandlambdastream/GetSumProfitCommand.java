package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class GetSumProfitCommand
    implements BiSetCommand<SalesSummaryRow,Double,Double> {
    private SalesSummaryRow salesSummaryRow;
    private Double value;

    public void set(SalesSummaryRow salesSummaryRow, Double value) {
        this.salesSummaryRow = salesSummaryRow;
	this.value = value;
    }

    public Double execute() {
        return value + salesSummaryRow.profit();
    }
}
