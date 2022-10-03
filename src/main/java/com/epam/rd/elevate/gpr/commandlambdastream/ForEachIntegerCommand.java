package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ForEachIntegerCommand {
    private List<Integer> listInteger;
    private SetIntegerCommand setIntegerCommand;

    public ForEachIntegerCommand(List<Integer> listInteger,
                                 SetIntegerCommand setIntegerCommand) {
        this.listInteger = listInteger;
        this.setIntegerCommand = setIntegerCommand;
    }

    public void execute() {
        for (Integer integer: listInteger) {
            setIntegerCommand.setInteger(integer);
            setIntegerCommand.execute();
        }
    }
}
