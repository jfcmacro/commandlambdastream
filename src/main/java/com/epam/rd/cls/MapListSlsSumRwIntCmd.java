package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class MapListSlsSumRwIntCmd
    implements GetListIntCmd {
    private List<SalesSummaryRow> listSlsSumRw;
    private List<Integer> listInt;
    private GetIntSetSlsSumRwCmd integerSlsSumRwCmd;

    public MapListSlsSumRwIntCmd(List<SalesSummaryRow> listSlsSumRw,
                                 GetIntSetSlsSumRwCmd integerSlsSumRwCmd) {
        this.listSlsSumRw = listSlsSumRw;
        this.integerSlsSumRwCmd = integerSlsSumRwCmd;
    }

    public List<Integer> getListInt() {
        return listInt;
    }

    public void execute() {
        listInt = new ArrayList<Integer>();
        for (SalesSummaryRow salesSummaryRow: listSlsSumRw) {
            integerSlsSumRwCmd.setSlsSumRw(salesSummaryRow);
            integerSlsSumRwCmd.execute();
            listInt.add(integerSlsSumRwCmd.getInt());
        }
    }
}
