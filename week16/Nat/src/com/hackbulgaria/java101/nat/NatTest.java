package com.hackbulgaria.java101.nat;

public class NatTest {

	public static void main(String[] args) {
		Nat zero = new Zero();
		Nat one = new Succ(zero);
		
		System.out.println(zero);
		System.out.println(zero.toInt());
		System.out.println(one);
		System.out.println(one.toInt());
		
		Nat two = one.add(one);
		System.out.println(two);
		
		System.out.println(two.minus(one));
	}

}
