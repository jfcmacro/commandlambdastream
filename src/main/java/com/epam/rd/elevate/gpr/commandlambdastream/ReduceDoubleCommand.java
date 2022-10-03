package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ReduceDoubleCommand
    implements GetDoubleCommand {
    private List<SalesSummaryRow> listSalesSummaryRow;
    private double retDouble;
    private GetDoubleSetDoubleSetSalesSummaryRowCommand doubleDoubleSalesSummaryRowCommand;

    public ReduceDoubleCommand(List<SalesSummaryRow> listSalesSummaryRow,
                               GetDoubleSetDoubleSetSalesSummaryRowCommand doubleDoubleSalesSummaryRowCommand,
                               double initialDouble) {
        this.listSalesSummaryRow = listSalesSummaryRow;
        this.doubleDoubleSalesSummaryRowCommand = doubleDoubleSalesSummaryRowCommand;
        this.retDouble = initialDouble;
    }

    public double getDouble() {
        return retDouble;
    }

    public void execute() {
        for (SalesSummaryRow salesSummaryRow: listSalesSummaryRow) {
            doubleDoubleSalesSummaryRowCommand.setDouble(retDouble);
            doubleDoubleSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            doubleDoubleSalesSummaryRowCommand.execute();
            retDouble = doubleDoubleSalesSummaryRowCommand.getDouble();
        }
    }
}
