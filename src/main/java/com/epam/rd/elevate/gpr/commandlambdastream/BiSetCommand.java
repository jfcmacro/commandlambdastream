package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface BiSetCommand<S,T,R> extends Command<R> {
    void set(S value);
    void set2(T value);
}
