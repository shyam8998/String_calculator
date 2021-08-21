package com.company;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
    // an empty string return zero
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	// return single value
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	// two numbers,coma deliminates,return sum
	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}
	// three numbers,coma deliminates,return sum
	@Test
    public void testThreeNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	// three numbers,\n deliminates,return sum
    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

     //negitive number throws as exception
    @Test
    public void testNegativeNumver(){
    	try {
			Calculator.add("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			Calculator.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
    }
    //number more than 1000 ignored
    @Test
    public void testOverThousand(){
    	assertEquals(2, Calculator.add("1000,2"));
    }

    @Test
    public void testOtherDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
}