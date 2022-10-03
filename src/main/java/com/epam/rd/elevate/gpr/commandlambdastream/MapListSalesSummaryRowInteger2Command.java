package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class MapListSalesSummaryRowInteger2Command
    implements GetListIntegerCommand {
    private List<SalesSummaryRow> listSalesSummaryRow;
    private List<Integer> listInteger;
    private GetIntegerSetSalesSummaryRowCommand integerSalesSummaryRowCommand;

    public MapListSalesSummaryRowInteger2Command(List<SalesSummaryRow> listSalesSummaryRow,
                       GetIntegerSetSalesSummaryRowCommand booleanSalesSummaryRowCommand) {
        this.listSalesSummaryRow = listSalesSummaryRow;
        this.integerSalesSummaryRowCommand = integerSalesSummaryRowCommand;
    }

    public List<Integer> getListInteger() {
        return listInteger;
    }

    public void execute() {
        listInteger = new ArrayList<Integer>();
        for (SalesSummaryRow salesSummaryRow: listSalesSummaryRow) {
            integerSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            integerSalesSummaryRowCommand.execute();
            listInteger.add(integerSalesSummaryRowCommand.getInteger());
        }
    }
}
