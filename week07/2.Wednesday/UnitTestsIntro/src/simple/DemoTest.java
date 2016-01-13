package simple;

import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Test;

public class DemoTest {

	@Test
	public void testAdd() {
		SimpleCalculator calc = new SimpleCalculator();
		int expected = 8;
		int actual = calc.add(6, 2);
		assertEquals("Test if addition works.", expected, actual);
	}

	@Test
	public void testSubtract() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		fail("Not yet implemented");
	}

}
