package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface SetListSalesSummaryRowCommand extends Command {
    void setSalesSummaryRows(List<SalesSummaryRow> salesSummaryRows);
}
