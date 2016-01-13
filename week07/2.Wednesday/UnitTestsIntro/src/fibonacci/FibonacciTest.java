package fibonacci;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {
	
	// [0: fib(0)=0](0.000 s)
	// [1: fib(1)=1](0.000 s)
	// [2: fib(2)=1](0.000 s)
	
    @Parameters(name = "{index}: fib({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        	     // 0 1 1 2 3 5 8
                 { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }  
           });
    }

    private int fInput;
    private int fExpected;

    public FibonacciTest(int input, int expected) {
        fInput= input;
        fExpected= expected;
        System.out.println("FibonacciTest " + fInput + " " + fExpected + " " + this);
    }

    @Test
    public void test() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}