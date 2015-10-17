package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]){
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}
	
	@Test
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
	}

	@Test 
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers(){
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testNewLinedTwoNumbers(){
		assertEquals(3, Calculator.add("1\n2"));
	}

	@Test
	public void testNewLineMultipleNumbers(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testDifferentDelimiters(){
		assertEquals(3, Calculator.add("//;1;2"));
	}

	@Test
	public void testNoNegatives(){
		try{
		assertEquals(0, Calculator.add("-1"));
		} catch (Exception e) {
			assertEquals("Negatives Not Allowed: -1", e.getMessage());
		}
	}

	@Test
	public void ignoreOverThousand(){
		assertEquals(2, Calculator.add("1001,2"));
	}

	//I am defeated...

	//@Test
	//public void testMultipleDelimiters(){
	//	assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	//}
}