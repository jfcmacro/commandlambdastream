package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ReduceIntegerCommand
    implements GetIntegerCommand {
    private List<SalesSummaryRow> listSalesSummaryRow;
    private int retInteger;
    private GetIntegerSetIntegerSetSalesSummaryRowCommand integerIntegerSalesSummaryRowCommand;

    public ReduceIntegerCommand(List<SalesSummaryRow> listSalesSummaryRow,
                               GetIntegerSetIntegerSetSalesSummaryRowCommand integerIntegerSalesSummaryRowCommand,
                               int initialInteger) {
        this.listSalesSummaryRow = listSalesSummaryRow;
        this.integerIntegerSalesSummaryRowCommand = integerIntegerSalesSummaryRowCommand;
        this.retInteger = initialInteger;
    }

    public int getInteger() {
        return retInteger;
    }

    public void execute() {
        for (SalesSummaryRow salesSummaryRow: listSalesSummaryRow) {
            integerIntegerSalesSummaryRowCommand.setInteger(retInteger);
            integerIntegerSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            integerIntegerSalesSummaryRowCommand.execute();
            retInteger = integerIntegerSalesSummaryRowCommand.getInteger();
        }
    }
}
