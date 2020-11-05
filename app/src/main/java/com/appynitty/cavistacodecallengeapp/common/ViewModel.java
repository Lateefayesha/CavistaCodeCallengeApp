package com.appynitty.cavistacodecallengeapp.common;

public interface ViewModel<T> {
    int layoutId();
    void setModel(T t);
}
