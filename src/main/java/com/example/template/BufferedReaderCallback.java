package com.example.template;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by KimYJ on 2017-03-03.
 */
public interface BufferedReaderCallback {
    Integer doSomethingWithReader(BufferedReader br) throws IOException;
}
