package com.epam.rd.cls;

import java.util.List;

public interface BiSetCommand<S,T,R> extends Command<R> {
    void set(S value);
    void set2(T value);
}
