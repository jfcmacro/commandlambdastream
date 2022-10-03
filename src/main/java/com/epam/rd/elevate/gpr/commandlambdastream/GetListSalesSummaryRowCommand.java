package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface GetListSalesSummaryRowCommand extends Command {
    List<SalesSummaryRow> getListSalesSummaryRows();
}
