package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ForEach2Command {
    private List<SalesSummaryRow> listSalesSummaryRow;
    private SetSalesSummaryRowCommand salesSummaryRowCommand;

    public ForEach2Command(List<SalesSummaryRow> listSalesSummaryRow,
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
