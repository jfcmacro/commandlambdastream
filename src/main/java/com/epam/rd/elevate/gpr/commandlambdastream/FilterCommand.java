package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class FilterCommand implements GetListSalesSummaryRowCommand {
    private List<SalesSummaryRow> listSalesSummaryRow;
    private List<SalesSummaryRow> returnSalesSummaryRows;
    private GetBooleanSetSalesSummaryRowCommand booleanSalesSummaryRowCommand;

    public FilterCommand(List<SalesSummaryRow> listSalesSummaryRow,
                         GetBooleanSetSalesSummaryRowCommand booleanSalesSummaryRowCommand) {
        this.listSalesSummaryRow = listSalesSummaryRow;
        this.booleanSalesSummaryRowCommand = booleanSalesSummaryRowCommand;
    }

    public List<SalesSummaryRow> getListSalesSummaryRows() {
        return returnSalesSummaryRows;
    }

    public void execute() {
        returnSalesSummaryRows = new ArrayList<SalesSummaryRow>();
        for (SalesSummaryRow salesSummaryRow: listSalesSummaryRow) {
            booleanSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            booleanSalesSummaryRowCommand.execute();
            if (booleanSalesSummaryRowCommand.getBoolean()) {
                returnSalesSummaryRows.add(salesSummaryRow);
            }
        }
    }
}
