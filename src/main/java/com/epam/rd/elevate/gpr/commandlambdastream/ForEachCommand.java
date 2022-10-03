package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ForEachCommand {
    private List<SalesSummaryRow> listSalesSummaryRow;
    private SetSalesSummaryRowCommand salesSummaryRowCommand;

    public ForEachCommand(List<SalesSummaryRow> listSalesSummaryRow,
                          SetSalesSummaryRowCommand salesSummaryRowCommand) {
        this.listSalesSummaryRow = listSalesSummaryRow;
        this.salesSummaryRowCommand = salesSummaryRowCommand;
    }

    public void execute() {
        for (SalesSummaryRow saleSummaryRow: listSalesSummaryRow) {
            salesSummaryRowCommand.setSalesSummaryRow(saleSummaryRow);
            salesSummaryRowCommand.execute();
        }
    }
}
