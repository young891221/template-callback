package com.example.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by KimYJ on 2017-03-03.
 */
public class Calculator {
    //BufferedReaderCallback를 Autowired로 찾는게 일반적이지만 여기서는 파라미터를 통해 전달
    //템플릿
    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            int ret = callback.doSomethingWithReader(br);
            return ret;
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
        BufferedReaderCallback sumCallback = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                Integer sum = 0;
                String line;
                while((line = br.readLine()) != null) {
                    sum += Integer.valueOf(line);
                }
                return sum;
            }
        };
        return fileReadTemplate(filepath, sumCallback);
    }

    //곱을 계산하는 콜백(람다형식)
    public Integer calcMultiply(String filepath) throws IOException {
        BufferedReaderCallback sumCallback = br -> {
            Integer multiply = 1;
            String line;
            while((line = br.readLine()) != null) {
                multiply *= Integer.valueOf(line);
            }
            return multiply;
        };
        return fileReadTemplate(filepath, sumCallback);
    }
}
