package com.sorb.testproject.service;

public interface ExportParams<T> {
    String[] getHeaders();

    String[] getValues(T t);
}
