package week1practice1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import week1.practice2.Calculator;
import week1.practice2.myCalc;

public class CalculatorTest {
@Test
	public void test1() {
		Calculator cal = new myCalc();
		int a = 3, b = 2;
		int testAnswer = 5;
		int actualAnswer = cal.add(3, 2);
		Assertions.assertEquals(testAnswer, actualAnswer);
	}
}
