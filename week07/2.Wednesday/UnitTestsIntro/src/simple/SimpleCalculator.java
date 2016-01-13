package simple;

public class SimpleCalculator {
	public int add(int a, int b) {
		return a+b;
	}
	
	public int subtract(int a, int b) {
		return a-b;
	}
	
	public double divide(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Divisor cannot be 0.");
		}
		
		return a/b;
	}
}
