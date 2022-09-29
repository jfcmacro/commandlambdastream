package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class FilterCommand implements GetListSetListSalesSummaryRowCommand {
    private List<SalesSummaryRow> salesSummaryRows;
    private List<SalesSummaryRow> returnSalesSummaryRows;
    private GetBooleanSetSalesSummaryRowCommand booleanSalesSummaryRowCommand;

    public FilterCommand(GetBooleanSetSalesSummaryRowCommand booleanSalesSummaryRowCommand) {
        this.booleanSalesSummaryRowCommand = booleanSalesSummaryRowCommand;
        this.returnSalesSummaryRows = null;
    }

    public void setSalesSummaryRows(List<SalesSummaryRow> salesSummaryRows) {
        this.salesSummaryRows = salesSummaryRows;
    }

    public List<SalesSummaryRow> getListSalesSummaryRows() {
        return returnSalesSummaryRows;
    }

    public void execute() {
        returnSalesSummaryRows = new ArrayList<SalesSummaryRow>();
        for (SalesSummaryRow salesSummaryRow: salesSummaryRows) {
            booleanSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            booleanSalesSummaryRowCommand.execute();
            if (booleanSalesSummaryRowCommand.getBoolean()) {
                returnSalesSummaryRows.add(salesSummaryRow);
            }
        }
    }
}
