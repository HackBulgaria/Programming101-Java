package com.hackbulgaria.java101.nat;

public class Succ extends Nat{
	
	private Nat n;
	
	public Succ(Nat n) {
		this.n = n;
	}

	@Override
	public boolean isZero() {
		return false;
	}

	@Override
	public Nat prev() {
		return n;
	}

	@Override
	public Nat add(Nat b) {
		if(b.isZero()) {
			return this;
		}
		
		return this.next().add(b.prev());
	}

	@Override
	public Nat minus(Nat b) {
		if(b.isZero()) {
			return this;
		}
		
		return this.prev().minus(b.prev());
	}

	@Override
	public Integer toInt() {
		return 1 + prev().toInt();
	}
	
	@Override
	public String toString() {
		return "Succ + " + prev().toString();
	}

}
