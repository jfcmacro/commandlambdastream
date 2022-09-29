package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;

public class ForEachDoubleCommand implements SetListDoubleCommand {
    private List<Double> listDoubles;
    private SetDoubleCommand setDoubleCommand;

    public ForEachDoubleCommand(SetDoubleCommand setDoubleCommand) {
        this.setDoubleCommand = setDoubleCommand;
    }

    public void setDoubles(List<Double> listDoubles) {
        this.listDoubles = listDoubles;
    }

    public void execute() {
        for (Double integer: listDoubles) {
            setDoubleCommand.setDouble(integer);
            setDoubleCommand.execute();
        }
    }
}
