package com.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	

}
