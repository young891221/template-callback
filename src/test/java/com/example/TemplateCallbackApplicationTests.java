package com.example;

import com.example.template.Calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateCallbackApplicationTests {
	Calculator calculator;
	String numFilepath;

	@Before
	public void init() {
		this.calculator = new Calculator();
		this.numFilepath = "C:/Users/Kim YJ/Documents/template-callback/numbers.txt";
	}

	@Test
	public void sumOfNumbers() throws IOException {
		assertThat(calculator.calcSum(this.numFilepath), is(10));
	}

	@Test
	public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calcMultiply(this.numFilepath), is(24));
	}

}
