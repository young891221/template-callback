package com.example.template3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by KimYJ on 2017-03-03.
 */
public class Calculator3 {
    //템플릿
    public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            T res = initVal;
            String line;
            while((line = br.readLine()) != null) {
                res = callback.doSomethingWithLine(line, res);
            }
            return res;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if(br != null) {
                try { br.close(); }
                catch (IOException e) { System.out.println(e.getMessage()); }
            }
        }
    }

    public String concatenate(String filepath) throws IOException {
        LineCallback<String> concatenateCallback = (line, value) -> value + line;
        return lineReadTemplate(filepath, concatenateCallback, "");
    }
}
