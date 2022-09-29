package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class MapListSalesSummaryRowIntegerCommand
    implements GetListIntegerSetListSalesSummaryRowCommand {
    private List<SalesSummaryRow> salesSummaryRows;
    private List<Integer> returnListInteger;
    private GetIntegerSetSalesSummaryRowCommand integerSalesSummaryRowCommand;

    public MapListSalesSummaryRowIntegerCommand(GetIntegerSetSalesSummaryRowCommand
                      integerSalesSummaryRowCommand) {
        this.integerSalesSummaryRowCommand = integerSalesSummaryRowCommand;
        this.returnListInteger = null;
    }

    public void setSalesSummaryRows(List<SalesSummaryRow> salesSummaryRows) {
        this.salesSummaryRows = salesSummaryRows;
    }

    public List<Integer> getListInteger() {
        return returnListInteger;
    }

    public void execute() {
        returnListInteger = new ArrayList<Integer>();
        for (SalesSummaryRow salesSummaryRow: salesSummaryRows) {
            integerSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            integerSalesSummaryRowCommand.execute();
            returnListInteger.add(integerSalesSummaryRowCommand.getInteger());
        }
    }
}
