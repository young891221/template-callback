package com.example.template2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by KimYJ on 2017-03-03.
 */
public class Calculator2 {
    //템플릿
    //initVal: 계산결과를 저장할 변수의 초기값
    public Integer lineReadTemplate(String filepath, LineCallback callback, int initVal) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            Integer res = initVal;
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

    //덧셈을 계산하다는 콜백
    public Integer calcSum(String filepath) throws IOException {
        LineCallback sumCallback = new LineCallback() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value + Integer.valueOf(line);
            }
        };
        return lineReadTemplate(filepath, sumCallback, 0);
    }

    //곱을 계산하는 콜백(람다형식)
    public Integer calcMultiply(String filepath) throws IOException {
        LineCallback multiplyCallback = (line, value) -> value * Integer.valueOf(line);
        return lineReadTemplate(filepath, multiplyCallback, 1);
    }
}
