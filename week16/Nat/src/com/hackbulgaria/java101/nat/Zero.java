package com.hackbulgaria.java101.nat;

public class Zero extends Nat{

	@Override
	public boolean isZero() {
		return true;
	}

	@Override
	public Nat prev() {
		throw new ArithmeticException("Can go beyound 0.");
	}

	@Override
	public Nat add(Nat b) {
		return b;
	}

	@Override
	public Nat minus(Nat b) {
		throw new ArithmeticException("Can go beyound 0.");
	}

	@Override
	public Integer toInt() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Zero";
	}

}
