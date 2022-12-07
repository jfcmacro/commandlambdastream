package com.epam.rd.cls;

import java.util.List;

public interface BiSetCmd<S,T,R> extends Command<R> {
    void set(S value1, T value2);
}
