package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class MapListSalesSummaryRowDoubleCommand
    implements GetListDoubleSetListSalesSummaryRowCommand {
    private List<SalesSummaryRow> salesSummaryRows;
    private List<Double> returnListDouble;
    private GetDoubleSetSalesSummaryRowCommand doubleSalesSummaryRowCommand;

    public
        MapListSalesSummaryRowDoubleCommand(GetDoubleSetSalesSummaryRowCommand
                                            doubleSalesSummaryRowCommand) {
        this.doubleSalesSummaryRowCommand = doubleSalesSummaryRowCommand;
        this.returnListDouble = null;
    }

    public void setSalesSummaryRows(List<SalesSummaryRow> salesSummaryRows) {
        this.salesSummaryRows = salesSummaryRows;
    }

    public List<Double> getListDouble() {
        return returnListDouble;
    }

    public void execute() {
        returnListDouble = new ArrayList<Double>();
        for (SalesSummaryRow salesSummaryRow: salesSummaryRows) {
            doubleSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            doubleSalesSummaryRowCommand.execute();
            returnListDouble.add(doubleSalesSummaryRowCommand.getDouble());
        }
    }
}
