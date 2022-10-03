package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ForEachDoubleCommand {
    private List<Double> listDouble;
    private SetDoubleCommand setDoubleCommand;

    public ForEachDoubleCommand(List<Double> listDouble,
                                SetDoubleCommand setDoubleCommand) {
        this.listDouble = listDouble;
        this.setDoubleCommand = setDoubleCommand;
    }

    public void execute() {
        for (Double integer: listDouble) {
            setDoubleCommand.setDouble(integer);
            setDoubleCommand.execute();
        }
    }
}
