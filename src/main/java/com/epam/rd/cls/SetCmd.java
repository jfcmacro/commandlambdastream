package com.epam.rd.cls;

import java.util.List;

public interface SetCmd<T,R> extends Command<R> {
    void set(T value);
}
