package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ForEachIntegerCommand implements SetListIntegerCommand {
    private List<Integer> listIntegers;
    private SetIntegerCommand setIntegerCommand;

    public ForEachIntegerCommand(SetIntegerCommand setIntegerCommand) {
        this.setIntegerCommand = setIntegerCommand;
    }

    public void setIntegers(List<Integer> listIntegers) {
        this.listIntegers = listIntegers;
    }

    public void execute() {
        for (Integer integer: listIntegers) {
            setIntegerCommand.setInteger(integer);
            setIntegerCommand.execute();
        }
    }
}
