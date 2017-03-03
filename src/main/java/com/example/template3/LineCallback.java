package com.example.template3;

/**
 * Created by KimYJ on 2017-03-03.
 */
public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
