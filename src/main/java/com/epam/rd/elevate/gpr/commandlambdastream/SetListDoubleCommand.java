package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface SetListDoubleCommand extends Command {
    void setDoubles(List<Double> listDouble);
}
