package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class MapListSlsSumRwDblCmd
    implements GetListDblCmd {
    private List<SalesSummaryRow> listSlsSumRw;
    private List<Double> listDbl;
    private GetDblSetSlsSumRwCmd doubleSlsSumRwCmd;

    public MapListSlsSumRwDblCmd(List<SalesSummaryRow> listSlsSumRw,
                                 GetDblSetSlsSumRwCmd doubleSlsSumRwCmd) {
        this.listSlsSumRw = listSlsSumRw;
        this.doubleSlsSumRwCmd = doubleSlsSumRwCmd;
    }

    public List<Double> getListDbl() {
        return listDbl;
    }

    public void execute() {
        listDbl = new ArrayList<Double>();
        for (SalesSummaryRow salesSummaryRow: listSlsSumRw) {
            doubleSlsSumRwCmd.setSlsSumRw(salesSummaryRow);
            doubleSlsSumRwCmd.execute();
            listDbl.add(doubleSlsSumRwCmd.getDbl());
        }
    }
}
