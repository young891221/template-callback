package com.example;

import com.example.template.Calculator;
import com.example.template2.Calculator2;

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
	Calculator2 calculator2;
	String numFilepath;

	@Before
	public void init() {
		this.calculator = new Calculator();
		this.calculator2 = new Calculator2();
		this.numFilepath = "C:/Users/Kim YJ/Documents/template-callback/numbers.txt";
	}

	@Test
	public void sumOfNumbers() throws IOException {
		assertThat(calculator.calcSum(this.numFilepath), is(10));
		assertThat(calculator2.calcSum(this.numFilepath), is(10));
	}

	@Test
	public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calcMultiply(this.numFilepath), is(24));
		assertThat(calculator2.calcMultiply(this.numFilepath), is(24));
	}

}
