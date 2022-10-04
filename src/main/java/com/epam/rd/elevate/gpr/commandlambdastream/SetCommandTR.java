package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface SetCommandTR<T,R> extends CommandT<R> {
    void set(T value);
}
