package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface GetListDoubleSetListSalesSummaryRowCommand
    extends SetListSalesSummaryRowCommand {
    List<Double> getListDouble();
}
