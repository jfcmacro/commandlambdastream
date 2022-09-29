package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface GetListIntegerSetListSalesSummaryRowCommand
    extends SetListSalesSummaryRowCommand {
    List<Integer> getListInteger();
}
