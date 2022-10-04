package com.epam.rd.elevate.gpr.commandlambdastream;

public interface CommandT<R> {
    R execute();
}
