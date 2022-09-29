package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ReduceCommand implements GetDoubleSetListSalesSummaryRowCommand {
    private List<SalesSummaryRow> salesSummaryRows;
    private double returnDouble;
    private GetDoubleSetSalesSummaryRowCommand doubleSalesSummaryRowCommand;
    private double initialDouble;

    public ReduceCommand(GetDoubleSetSalesSummaryRowCommand doubleSalesSummaryRowCommand,
                         double initialDouble) {
        this.doubleSalesSummaryRowCommand = doubleSalesSummaryRowCommand;
        this.returnDouble = 0.0;
        this.initialDouble = initialDouble;
    }

    public void setSalesSummaryRows(List<SalesSummaryRow> salesSummaryRows) {
        this.salesSummaryRows = salesSummaryRows;
    }

    public double getDouble() {
        return returnDouble;
    }

    public void execute() {
        returnDouble = 0.0;
        for (SalesSummaryRow salesSummaryRow: salesSummaryRows) {
            doubleSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            doubleSalesSummaryRowCommand.execute();
            returnDouble += doubleSalesSummaryRowCommand.getDouble();
        }
    }
}
