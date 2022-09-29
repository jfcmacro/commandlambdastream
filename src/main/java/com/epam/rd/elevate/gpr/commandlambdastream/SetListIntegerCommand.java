package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface SetListIntegerCommand extends Command {
    void setIntegers(List<Integer> listInteger);
}
