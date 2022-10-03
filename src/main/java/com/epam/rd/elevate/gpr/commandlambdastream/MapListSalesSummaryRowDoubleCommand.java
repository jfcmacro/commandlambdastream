package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class MapListSalesSummaryRowDoubleCommand
    implements GetListDoubleCommand {
    private List<SalesSummaryRow> listSalesSummaryRow;
    private List<Double> listDouble;
    private GetDoubleSetSalesSummaryRowCommand doubleSalesSummaryRowCommand;

    public MapListSalesSummaryRowDoubleCommand(List<SalesSummaryRow> listSalesSummaryRow,
                       GetDoubleSetSalesSummaryRowCommand doubleSalesSummaryRowCommand) {
        this.listSalesSummaryRow = listSalesSummaryRow;
        this.doubleSalesSummaryRowCommand = doubleSalesSummaryRowCommand;
    }

    public List<Double> getListDouble() {
        return listDouble;
    }

    public void execute() {
        listDouble = new ArrayList<Double>();
        for (SalesSummaryRow salesSummaryRow: listSalesSummaryRow) {
            doubleSalesSummaryRowCommand.setSalesSummaryRow(salesSummaryRow);
            doubleSalesSummaryRowCommand.execute();
            listDouble.add(doubleSalesSummaryRowCommand.getDouble());
        }
    }
}
