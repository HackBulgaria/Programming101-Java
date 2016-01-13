package simple;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class SimpleCalculatorTest {
	
	@Test
	public void testAdd() {
		assertEquals("Test if addition works.", 7, mCalc.add(2, 5));
	}

	@Test
	public void testSubtract() {
		assertEquals("Test if subtraction works.", 4, mCalc.subtract(8, 4));
	}

	@Test
	public void testDivision() {
		assertEquals(4.5, mCalc.divide(9, 2), 0.0001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCatchesZeroDivision() {
		mCalc.divide(2, 0);
	}
	
	 private static SimpleCalculator mCalc;
	 
	 @BeforeClass
	 public static void initCalculator() {
	  	mCalc = new SimpleCalculator();
	 }
	  
	 @AfterClass
	 public static void destroyCalculator() {
	  	mCalc = null;
	 }
	 
	 @Before
	 public static void initBeforeCalculator() {
	  	// called before EACH TEST
	 }
	 

}
