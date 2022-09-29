package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ReduceIntegerCommand implements GetIntegerSetListSalesSummaryRowCommand {
    private List<SalesSummaryRow> salesSummaryRows;
    private int returnInteger;
    private GetIntegerSetSalesSummaryRowCommand integerSalesSummaryRowCommand;
    private int initial;

    public ReduceIntegerCommand(GetIntegerSetSalesSummaryRowCommand integerSalesSummaryRowCommand,
                                int initial) {
        this.integerSalesSummaryRowCommand = integerSalesSummaryRowCommand;
        this.initial = initial;
    }

    public void setSalesSummaryRows(List<SalesSummaryRow> salesSummaryRows) {
        this.salesSummaryRows = salesSummaryRows;
    }

    public int getInteger() {
        return returnInteger;
    }

    public void execute() {
        returnInteger = initial;
        for (SalesSummaryRow salesSummaryRow: salesSummaryRows) {
            integerSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            integerSalesSummaryRowCommand.execute();
            returnInteger = integerSalesSummaryRowCommand.getInteger();
        }
    }
}
