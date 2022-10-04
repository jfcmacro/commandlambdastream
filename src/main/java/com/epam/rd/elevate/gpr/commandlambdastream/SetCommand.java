package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface SetCommand<T,R> extends Command<R> {
    void set(T value);
}
