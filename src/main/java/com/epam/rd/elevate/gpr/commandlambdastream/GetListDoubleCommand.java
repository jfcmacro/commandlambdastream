package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface GetListDoubleCommand
    extends Command {
    List<Double> getListDouble();
}
