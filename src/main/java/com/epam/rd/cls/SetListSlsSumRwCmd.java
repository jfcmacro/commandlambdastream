package com.epam.rd.cls;

import java.util.List;

public interface SetListSlsSumRwCmd extends Command {
    void setSalesSummaryRows(List<SalesSummaryRow> salesSummaryRows);
}
