package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ForEachCommand implements SetListSalesSummaryRowCommand {
    private List<SalesSummaryRow> salesSummaryRows;
    private SetSalesSummaryRowCommand salesSummaryRowCommand;

    public ForEachCommand(SetSalesSummaryRowCommand salesSummaryRowCommand) {
        this.salesSummaryRowCommand = salesSummaryRowCommand;
    }

    public void setSalesSummaryRows(List<SalesSummaryRow> salesSummaryRows) {
        this.salesSummaryRows = salesSummaryRows;
    }

    public void execute() {
        for (SalesSummaryRow saleSummaryRow: salesSummaryRows) {
            salesSummaryRowCommand.setSalesSummaryRow(saleSummaryRow);
            salesSummaryRowCommand.execute();
        }
    }
}
