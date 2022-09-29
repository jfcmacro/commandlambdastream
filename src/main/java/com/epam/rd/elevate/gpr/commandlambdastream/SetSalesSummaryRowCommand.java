package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface SetSalesSummaryRowCommand extends Command {
    void setSalesSummaryRow(SalesSummaryRow salesSummaryRow);
}
