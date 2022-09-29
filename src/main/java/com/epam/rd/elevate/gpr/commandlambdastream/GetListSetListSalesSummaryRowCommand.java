package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface GetListSetListSalesSummaryRowCommand extends SetListSalesSummaryRowCommand {
    List<SalesSummaryRow> getListSalesSummaryRows();
}
