package com.epam.rd.cls;

import java.util.List;

public interface GetListSlsSumRwCmd extends Command {
    List<SalesSummaryRow> getListSlsSumRws();
}
