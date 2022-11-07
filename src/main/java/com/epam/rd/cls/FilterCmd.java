package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class FilterCmd implements GetListSlsSumRwCmd {
    private List<SalesSummaryRow> listSlsSumRw;
    private List<SalesSummaryRow> returnSlsSumRws;
    private GetBoolSetSlsSumRwCmd booleanSlsSumRwCmd;

    public FilterCmd(List<SalesSummaryRow> listSlsSumRw,
                     GetBoolSetSlsSumRwCmd booleanSlsSumRwCmd) {
        this.listSlsSumRw = listSlsSumRw;
        this.booleanSlsSumRwCmd = booleanSlsSumRwCmd;
    }

    public List<SalesSummaryRow> getListSlsSumRws() {
        return returnSlsSumRws;
    }

    public void execute() {
        returnSlsSumRws = new ArrayList<SalesSummaryRow>();
        for (SalesSummaryRow salesSummaryRow: listSlsSumRw) {
            booleanSlsSumRwCmd.setSlsSumRw(salesSummaryRow);
            booleanSlsSumRwCmd.execute();
            if (booleanSlsSumRwCmd.getBool()) {
                returnSlsSumRws.add(salesSummaryRow);
            }
        }
    }
}
