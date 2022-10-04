package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public interface BiSetCommandSTR<S,T,R> extends CommandT<R> {
    void set(S value);
    void set2(T value);
}
