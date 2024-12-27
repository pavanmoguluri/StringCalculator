package com.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringCalculatorAssignment0ApplicationTests {
	
	StringCalculator stringCalculator = new StringCalculator();
	
	@Test
	public void positiveInputs() {
		assertEquals(6,stringCalculator.Add("1,2,3"));
	}
	
	@Test
	public void OneNegativeInputs() {
		assertThrows(IllegalArgumentException.class, ()->{
			stringCalculator.Add("1,2,-3");
		});
	}
	
	@Test
	public void onlyChars() {
		String inpStr = ",y,x";
		assertEquals(0,stringCalculator.Add(inpStr));
	}
	
	@Test
	public void noNumOrChar() {
		String inpStr = ",,";
		assertEquals(0,stringCalculator.Add(inpStr));
	}
	
	@Test
	public void gt1000() {
		String inpStr = "1,1002";
		assertEquals(1,stringCalculator.Add(inpStr));
	}
	
	@Test
	public void gt1000False() {
		String inpStr = "1,1002";
		assertFalse(1003 == stringCalculator.Add(inpStr));
	}
	
	@Test
	public void semicolonDelimeter() {
		String inpStr = "//;\\n1;2";
		assertEquals(3,stringCalculator.Add(inpStr));
	}
	
	@Test
	public void delimOfAnyLen() {
		String inpStr = "//[***]\\n1***2***3";
		assertEquals(6,stringCalculator.Add(inpStr));
	}
	
	@Test
	public void multipleDelims() {
		String inpStr = "//[*][%]\n1*2%3";
		assertEquals(6,stringCalculator.Add(inpStr));
	}
	
	@Test
	public void multipleDelimsLongLength() {
		String inpStr = "//[**][%%]\\n1**2%%3";
		assertEquals(6,stringCalculator.Add(inpStr));
	}
	
	@Test
	public void getInvokeCount() {
//		assertEquals(stringCalculator.getCount(), 0);
		stringCalculator.Add("1,2,3");
		stringCalculator.Add("//[***]\\\\n1***2***3");
		stringCalculator.Add("//[*][%]\\n1*2%3");
		assertEquals(stringCalculator.getCount(), 3);
	}

}
