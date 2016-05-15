package com.hackbulgaria.java101.nat;

public abstract class Nat {
	public abstract boolean isZero();

	public Nat next() {
		return new Succ(this);
	}

	public abstract Nat prev();
	public abstract Nat add(Nat b);
	public abstract Nat minus(Nat b);
	public abstract Integer toInt();
	
}
