package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface GetListIntegerCommand
    extends Command {
    List<Integer> getListInteger();
}
