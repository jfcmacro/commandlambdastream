package com.epam.rd.elevate.gpr.commandlambdastream;

public interface Command<R> {
    R execute();
}
