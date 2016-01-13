package fibonacci;

public class Fibonacci {
	public static int compute(int n) {
		if (n <= 1) return n;
        else return compute(n-1) + compute(n-2);
	}
}
